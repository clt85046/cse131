package business;

public class CashFlows {
	
	public CashFlows(Money ... f) {
		flows = f;
	}
	
	public CashFlows() {
		flows = new Money[0];
	}
	
	public Money getFlow(int year) {
		if(year < 1 || year > flows.length)
			throw new IllegalArgumentException("The year provided was not valid");
		return flows[year-1];
	}
	
	public int getNumberOfFlows() {
		return flows.length;
	}
	
	public void adjustFlow(int year, double amount) {
		if(year < 1 || year > flows.length)
			throw new IllegalArgumentException("The year provided was not valid");
		flows[year - 1] = new Money(amount);
	}
	
	public void addFlow(double amount) {
		Money[] new_flows = new Money[flows.length+1];
		for(int i = 0; i < flows.length; i++)
		{
			new_flows[i] = flows[i];
		}
		new_flows[new_flows.length-1] = new Money(amount);
		flows = new_flows;
	}
	
	public void removeFlow(int year) {
		if(flows.length == 0)
			throw new ArrayIndexOutOfBoundsException("The list of flows is empty, nothing can be removed");
		if(year < 1 || year > flows.length)
			throw new IllegalArgumentException("The year provided was not valid");
		Money[] new_flows = new Money[flows.length-1];
		for(int i = 0; i < new_flows.length; i++)
		{
			if(i != year - 1)
				new_flows[i] = flows[i];
		}
		flows = new_flows;
	}
	
	private Money[] flows;
}
