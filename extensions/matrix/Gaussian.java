package matrix;

public class Gaussian {
	
	Matrix coeff;
	Matrix constants;
	
	public Gaussian(Matrix matCoeff, Matrix matConst){
		this.coeff = matCoeff;
		this.constants = matConst;
	}
	
	
	/**
	 * The hard part!
	 * @return
	 */
	public Matrix getSolution(){
		return null;  // FIXME
	}
	
	public String toString(){
		String string ="";
		for(int i=0; i<this.coeff.getNumRows(); i++){
			string+="\n";
			for(int j=0; j<this.coeff.getNumCols()+1; j++){
				if(j==this.coeff.getNumCols()){
					string+= this.constants.getValue(i,0)+ "  ";
				}else{
					string+= this.coeff.getValue(i,j) + "  ";
				}
			}
		}
		System.out.println(string);

		return string;
	}

}
