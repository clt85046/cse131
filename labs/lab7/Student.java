package lab7;

public class Student {
	
	private String firstname,lastname;
	private int ID,credits;
	private double GPA;
	
	
	/**
	 * constructor
	 * @param firstname
	 * @param lastname
	 * @param ID
	 */
	public Student(String firstname,String lastname,int ID){
		this.firstname = firstname;
		this.lastname = lastname;
		this.ID = ID;
		this.credits = 0;
		this.GPA = 0.0;
	}
	
	
	/**
	 * Accessor		
	 * @return Name
	 */
	public String getName(){
		return firstname+" "+lastname;
	}
	
	/**
	 * Accessor
	 * @return ID
	 */
	public int getStudentID(){
		return ID;
	}
	
	/**
	 * Accessor
	 * @return credits
	 */
	public int getCredits(){
		return credits;
	}
	
	/**
	 * Accessor
	 * @return GPA
	 */
	public double getGPA(){
		return GPA;
	}
	
	/**
	 * Accessor 
	 * @return find student`s classstanding
	 */
	public String getClassStanding(){
		if(credits < 30){
			return "Freshman";
		}
		else{
			if(credits< 60){
				
				return "Sophomore";
			}
				else {
					if(credits<90){
						return "Junior";
					}
					else{
						return "Senior";
					}
				}
					
		}
	}
	
	/**
	 * ToString
	 */
	public String toString(){
		return firstname+lastname+ID;
	}
	
	/**
	 * Accessor
	 * @param grade
	 * @param credit
	 * @return GPA
	 */
	public double submitGrade(double grade,int credit){
		
		GPA = Math.round((GPA*credits+grade*credit)/(credits+credit)*1000)/1000.0;
		credits = credits+credit;
		//System.out.println("qdwqa"+GPA);
		return GPA;
	}
	
	/**
	 * Accessor
	 * @param b
	 * @return new student
	 */
	public Student createLegacy(Student b) {
		Student s1=new Student("","",0);
		s1.firstname= firstname+" "+lastname;
		s1.lastname = b.firstname+" "+b.lastname;
		s1.ID = ID + b.getStudentID();
		s1.GPA = (GPA+b.getGPA())/2;
		s1.credits = Math.max(credits, b.credits);
		return s1;	
	}
	
	
	
	
	

}
