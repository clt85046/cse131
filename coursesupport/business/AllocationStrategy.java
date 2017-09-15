package business;

public abstract class AllocationStrategy {
	
	public AllocationStrategy(Money investment, double inRisky) {
		initialFunds = investment;
		risky = inRisky;
		period = 0;
	}

	public void setRiskyAsset(Asset a) {
		riskyAsset = a;
	}
	
	public void setRisklessAsset(Asset a) {
		risklessAsset = a;
	}
	
	public Money currentWorth() {
		if(period == 0)
			return initialFunds;
		else
			return riskyAsset.getValue().plus(risklessAsset.getValue());
	}

	public int elapsedPeriods() {
		return period;
	}
	
	public void stepPeriod() {
		distributeFunds();
		riskyAsset.stepPeriod();
		risklessAsset.stepPeriod();
		period++;
	}
	
	public String toString() {
		return currentWorth().toString();
	}
	
	public double getRisky() {
		return risky;
	}
	
	public abstract void distributeFunds();
	
	protected Money initialFunds;
	protected double risky;
	protected int period;
	protected Asset riskyAsset, risklessAsset;
	
	public static void main(String args[]) {
		Money investment = new Money(10000);
		StrategicAllocation sa = new StrategicAllocation(investment, .5);
		DynamicAllocation da = new DynamicAllocation(investment, .5);
		ConstantWeightAllocation cwa = new ConstantWeightAllocation(investment, .5);
		InsuredAllocation ia = new InsuredAllocation(investment, .5);

		sa.setRisklessAsset(new Asset(.1));
		sa.setRiskyAsset(new Asset(0, .5));
		da.setRisklessAsset(new Asset(.1));
		da.setRiskyAsset(new Asset(0, .5));
		cwa.setRisklessAsset(new Asset(.1));
		cwa.setRiskyAsset(new Asset(0, .5));
		ia.setRisklessAsset(new Asset(.1));
		ia.setRiskyAsset(new Asset(0, .5));
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println("For period = " + i + ":");
			System.out.println("SA worth: " + sa);
			System.out.println("SA risk: " + sa.getRisky());
			System.out.println("DA worth: " + da);
			System.out.println("DA risk: " + da.getRisky());
			System.out.println("CWA worth: " + cwa);
			System.out.println("CWA risk: " + cwa.getRisky());
			System.out.println("IA worth: " + ia);
			System.out.println("IA risk: " + ia.getRisky());
			sa.stepPeriod();
			da.stepPeriod();
			cwa.stepPeriod();
			ia.stepPeriod();
		}
	}
}
