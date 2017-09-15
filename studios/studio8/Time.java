package studio8;

public class Time  {
	


	private int hour,minute;
	private boolean format;
	
	/**
	 * constructor
	 * @param a
	 * @param format
	 */
	public Time(variables a,boolean format) {
		//super();
		this.hour = a.getHour();
		this.minute = a.getMinute();
		this.format = format;
		hour = hour+1;
	}
	
	public String toString() {
		if(format == true){
			return "Time [hour=" + hour + ", minute=" + minute + ", format=" +"24H"+ "]";
		}
		else{
			if(hour > 12){
				return "Time [hour=" + (hour-12) + ", minute=" + minute + ", format=" +"12H"+ "]";
			}
			else
			{
				return "Time [hour=" + (hour) + ", minute=" + minute + ", format=" +"12H"+ "]";
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		variables time = new variables(12,25,2016,13,22,true);
		Time times = new Time(time,true);
		System.out.println(times.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (format ? 1231 : 1237);
		result = prime * result + hour;
		result = prime * result + minute;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (format != other.format)
			return false;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}

	
	

}
