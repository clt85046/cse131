package lab8;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

	final private LinkedList<Double> list;
	private int i;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//
		// Set the instance variable (list) to be a new linked list of Double type
		//
		this.list = new LinkedList<Double>();   // FIXME
		this.i = 0;
	}

	/*
	 * toString
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		int i = 0;
		String k = " ";
		for (double p:list){
			if(p>=0){
				if(p!=0)
				{
					if(i==0){
						k=k+p;
					}
					else{
						k = k+"+" +p+"x^"+i;
					}
				}
				i=i+1;
			}
			else{
				if(p!=0){
					if(i==0){
						k=k+p;
					}
					else{
						k = k+p+"x^"+i;
					}
				}
				i=i+1;
			}
		}
		if(list.isEmpty()){
			return "0";
		}
		else{
			return "A polynomial"+k;
		}
		 // FIXME
	}

	/**
	 * Accessor
	 * @param coeff
	 * @return add coeff in to polynomial
	 */
	public Polynomial addTerm(double coeff) {
		//
		// FIXME
		//
		list.add(coeff);
		return this;  // required by lab spec
	}
	
	/**
	 * Accessor
	 * @param x
	 * @return evaluate the polynomial
	 */
	public double evaluate(double x) {
		//LinkedList<Double> list = list;
		
		double firstcoeff = 0;
		//int i =0 ;
		//System.out.println("size= "+list.size());
		if(list.size()==0){
			i=0;
			return 0;
		}
		if(list.size()==(i+1))
		{	i=0;
			return list.getLast();
		}
		else {
			
			firstcoeff = list.get(i);
			//System.out.println(firstcoeff);
			i=i+1;
			return firstcoeff+x*evaluate(x);
		}
		
		// FIXME
	}
	
	/**
	 * Accessor
	 * @return the derivative of polynomial
	 */
	public Polynomial derivative() {
		Polynomial p1 = new Polynomial();
		//int k = 0 ;
		if(list.size()<=1){
			i=0;
			return p1;
		}
		else{
			for(int j=1;j<list.size();j++){
				p1.addTerm(j*list.get(j));
				}
				return p1;
			}
			
		}
	
	
	/**
	 * Accessor
	 * @param another
	 * @return sum of two polynomial
	 */
	public Polynomial sum(Polynomial another) {
		Polynomial newp =new Polynomial();
		int l1 = list.size();
		int l2 = another.list.size();
		int l = Math.max(l1,l2);
		if (l==0){
			return newp;
		}
		if(l1>=l2){
			for(int i = 0;i<l2;i++){
				newp.list.add(list.get(i)+another.list.get(i));
			}
			for (int i=l2;i<l1;i++){
				newp.list.add(list.get(i));
			}
		}
		else{
			for(int i = 0;i<l1;i++){
				newp.list.add(list.get(i)+another.list.get(i));
			}
			for (int i=l1;i<l2;i++){
				newp.list.add(another.list.get(i));
		}
		}
//		
//	    
		//System.out.println("newp= "+newp);
		return newp;   // FIXME
	}

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}
