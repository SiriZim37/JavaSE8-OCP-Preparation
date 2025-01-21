package klausur;

public class TestException1 {
/*
 Gegeben ist der Code:

  try {
    System.out.print(5/0);
    System.out.print("success ");
  } catch(ArithmeticException | NumberFormatException e) {
    e = null;
    System.out.print("exception ");
  } 

  System.out.print("done");

Was ist richtig?

[   ] Compilerfehler
[   ] success done
[   ] exception done
[   ] success exception done
 */
	
	public static void main(String[] args) {
		
		  try {
			    System.out.print(5/0);
			    System.out.print("success ");
			  } catch(ArithmeticException | NumberFormatException e) {
//			    e = null;				// The parameter e of a multi-catch block cannot be assigned
			    System.out.print("exception ");
			  } 
		  
	}
}
