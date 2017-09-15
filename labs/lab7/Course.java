package lab7;

public class Course {
	private String name;
	private int credits,seats;
	private double gpa;
	private Student[] rosters;
	
	/**
	 * constructor
	 * @param name
	 * @param credits
	 * @param seats
	 */
	public Course(String name,int credits,int seats){
		this.name = name;
		this.credits = credits;
		this.seats = seats;
		this.rosters= new Student[seats];
		
	}
	
	/**
	 * Accessor
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Accessor
	 * @return remainseats
	 */
	public int getRemainingSeats(){
		return seats;
	}
	
	/**
	 * Accessor 
	 * @param a
	 * @return whether to add student
	 */
	public boolean addStudent(Student a){
		seats=seats-1;
		if(getRemainingSeats()>=0){
			//gpa = gpa+a.getGPA();
			generateRoster(a);
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Accessor
	 * @param a
	 * @return generate rosters
	 */
	public Student[] generateRoster(Student a){
		rosters[rosters.length-seats-1]=a;
		return rosters;
	}
	
	/**
	 * Accessor
	 * @return average GPA
	 */
	public double averageGPA(){
		double gpa = 0;
		double t=0;
		for(int i=0;i<rosters.length;i++){
			if(rosters[i]!=null){
				gpa=gpa+rosters[i].getGPA();
				t=t+1;
			}
			
			
		}
		return Math.round(gpa/t*1000)/1000.0;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "Course [name=" + name + ", credits=" + credits + "]";
	}

}
