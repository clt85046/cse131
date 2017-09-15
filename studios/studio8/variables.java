package studio8;

public class variables {
	private final int month,day,year,hour,minute;
	private final boolean holiday;
	/**
	 * construtor
	 * @param month
	 * @param day
	 * @param year
	 * @param hour
	 * @param minute
	 * @param holiday
	 */
	public variables(int month, int day, int year, int hour, int minute,boolean holiday) {
		
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.holiday = holiday;
	}

	public String toString() {
		return "variables [month=" + month + ", day=" + day + ", year=" + year + ", hour=" + hour + ", minute=" + minute
				+ ", holiday=" + holiday + "]";
	}
	
	/**
	 * Accessor
	 * @return
	 */
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public boolean isHoliday() {
		return holiday;
	}
	

	

	

	
	

}
