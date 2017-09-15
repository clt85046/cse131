package exercises5;

import book.ch3.Split;

public class StringMethods {
	
	//
	// Below are the methods defined for this exercise
	//   The names are not prescribed in the assignment, so choose
	//   names you like (that are meaningful)
	//
	
	//
	// First one is completed for you:
	//
	
	public static String selfConcat(String s) {
		return s + s;
	}
	public static String copy(String s,int n){
		String s1 = "";
		for (int i=0;i<n;i++)
		{
			s1=s1+s;
		}
		return s1;
	
	}
	public static String join(String[] array, String joiner){
		String x ="";
		for(int i =0 ;i<array.length;i++)
		{
			x=x+array[i]+joiner;
		}
		return x;
	}
	
	public static void main(String[] args) {
		
		//
		// Testing the methods
		//
		System.out.println(selfConcat("echo"));
		System.out.println(copy("hello",5));
		String a ="asd sda sad asd";
		String[] b = a.split(" ");
		for (int i =0 ;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		System.out.println((join(b,"jimo")));
	}

}
