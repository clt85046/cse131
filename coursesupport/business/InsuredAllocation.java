package business;

public class InsuredAllocation extends AllocationStrategy {

	public InsuredAllocation(Money investment, double inRisk) {
		super(investment, inRisk);
		initialRisk = inRisk;
	}
	public void distributeFunds() {
		Money funds = currentWorth();
		
		if(funds.compareTo(initialFunds) < 0) {
			risky = 0;
		}
		else if(riskyAsset.getValue().equals(new Money(0))) {
			risky = initialRisk;
		}
		else {
			risky = risky + (riskyAsset.percentChange() - risklessAsset.percentChange());
				if (risky <= 0)
					risky = .1;
				if (risky > 1)
					risky = 1;
		}
		
		Money investedRisky = funds.times(risky);
		Money investedRiskless = funds.minus(investedRisky);
		riskyAsset.invest(investedRisky);
		risklessAsset.invest(investedRiskless);
	}
	private double initialRisk;

}
