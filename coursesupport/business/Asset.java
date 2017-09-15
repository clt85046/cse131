package business;

public class Asset {
	
	public Asset(double mean, double range)
	{
		this.mean = mean;
		this.range = range;
		initialInvestment = invested = new Money(0);
	}
	
	public Asset(double mean) {
		this.mean = mean;
		range = 0;
		initialInvestment = invested = new Money(0);
	}
	public void setMeanReturn(double mean) {
		this.mean = mean;
	}
	
	public void setReturnRange(double range) {
		this.range = range;
	}
	
	public double getMean() {
		return mean;
	}
	
	public double getRange() {
		return range;
	}	
	
	public double calculateReturnRate() {
		return mean + (range * (Math.random() - 0.5));
	}
	
	public void stepPeriod() {
		invested = invested.plus((invested.times(calculateReturnRate())));
	}
	
	public void invest(Money amount) {
		invested = initialInvestment = amount;
	}
	
	public Money getValue() {
		return invested;
	}
	
	public double percentChange() {
		if (initialInvestment.compareTo(new Money(0)) == 0)
			return 0;
		else if(range == 0)
			return mean;
		else
			return (invested.getDoubleValue() - initialInvestment.getDoubleValue()) / initialInvestment.getDoubleValue();
	}
	private double mean;
	private double range;
	private Money invested;
	private Money initialInvestment;
}
