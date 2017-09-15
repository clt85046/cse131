package business;

public class StrategicAllocation extends AllocationStrategy{

	public StrategicAllocation(Money investment, double inRisky) {
		super(investment, inRisky);
	}

	public void distributeFunds() {
		if(period == 0)
		{
			Money investedRisky = initialFunds.times(risky);
			Money investedRiskless = initialFunds.minus(investedRisky);
			riskyAsset.invest(investedRisky);
			risklessAsset.invest(investedRiskless);
		}
	}
}
