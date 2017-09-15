package business;

public class DynamicAllocation extends AllocationStrategy {

	public DynamicAllocation(Money investment, double inRisky) {
		super(investment, inRisky);
	}

	public void distributeFunds() {
		Money funds = currentWorth();
		if(period != 0)
		{

			System.out.println("DA risky change: " + riskyAsset.percentChange());
			System.out.println("DA riskless change: " + risklessAsset.percentChange());
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
}
