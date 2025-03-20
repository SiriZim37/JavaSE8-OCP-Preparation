package aufgaben.calculation;

public class Factorial extends Operation{
	
	@Override
	public double execute(double... operands) {

		  
	    int n = (int) operands[0];
	        if (n < 0) {
	            throw new IllegalArgumentException("Fakultät kann nicht für negative Zahlen berechnet werden.");
	    }
	        
        return berechneFakultaet((int)operands[0]);
    }

	// Recursive Methode zur Berechnung der Fakultät
	public static long berechneFakultaet(int n) {
		
		if(n<0)  return -1;  	
		if(n==1||n==0) return 1;

		
	    return   n * berechneFakultaet(n - 1);
	}
}