package business;

public class ConstantWeightAllocation extends AllocationStrategy{

	public ConstantWeightAllocation(Money investment, double inRisky) {
		super(investment, inRisky);
	}

	public void distributeFunds() {
		Money funds = currentWorth();
		if(period != 0)
			if(Math.abs(riskyAsset.percentChange()) >= 0.05 || Math.abs(risklessAsset.percentChange()) >= 0.05)
				funds = currentWorth();
			else 
				return;
		
		Money investedRisky = funds.times(risky);
		Money investedRiskless = funds.minus(investedRisky);
		riskyAsset.invest(investedRisky);
		risklessAsset.invest(investedRiskless);
		System.out.println("CWA risky worth: " + riskyAsset.getValue());
		System.out.println("CWA riskless worth: " + risklessAsset.getValue());
	}
}
