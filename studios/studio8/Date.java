package studio8;

import java.util.HashSet;
import java.util.LinkedList;

public class Date {
	private  int month,date,year;
	public boolean holiday;
	/**
	 * constructor
	 * @param month
	 * @param date
	 * @param year
	 * @param holiday
	 */
	public Date(variables a) {
		this.month = a.getMonth();
		this.date = a.getDay();
		this.year = a.getYear();
		this.holiday =a.isHoliday();
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return "Date [month=" + month + ", date=" + date + ", year=" + year + ", holiday=" + holiday + "]";
	}

	public static void main(String[] args) {
		variables day = new variables(12,25,2016,13,22,true);
		variables day1 = new variables(12,23,2016,13,22,true);
		variables day2 = new variables(12,24,2016,13,22,true);
		Date days = new Date(day);
		Date d1 = new Date(day1);
		Date d2 = new Date(day1);
		LinkedList<Date> list = new LinkedList<Date>();
		list.add(d1);
		list.add(days);
		list.add(d1);
		System.out.println(d1.equals(d2));
		System.out.println(list);
		System.out.println(days.toString());
		
		HashSet<Date> set = new HashSet<Date>();
		set.add(d1);
		set.add(d2);
		set.add(d1);
		System.out.println(set);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + (holiday ? 1231 : 1237);
		result = prime * result + month;
		result = prime * result + year;
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
		Date other = (Date) obj;
		if (date != other.date)
			return false;
		if (holiday != other.holiday)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}


	

}
