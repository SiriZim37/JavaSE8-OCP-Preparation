package ocpexam;


class AssertionTest3 { 
	
    public static void main(String[] args) { 
    	int rateOfInterest = 0;
		String accountType = "LOAN";
		switch (accountType) {
		case "RD":
			rateOfInterest = 5;
			break;
		case "FD":
			rateOfInterest = 10;
			break;
		default:
			assert false : "No interest for this account"; // line n1
		}
		System.out.println("Rate of interest:" + rateOfInterest);
	}
    /*
		Question No : 97 

	Given 
	
	class RateOfInterest {
		public static void main(String[] args) {
			int rateOfInterest = 0;
			String accountType = "LOAN";
			switch (accountType) {
			case "RD":
				rateOfInterest = 5;
				break;
			case "FD":
				rateOfInterest = 10;
				break;
			default:
				assert false : "No interest for this account"; // line n1
			}
			System.out.println("Rate of interest:" + rateOfInterest);
		}
	}
	
	and the command:
	
	java –ea RateOfInterest
	
	What is the result?
	
	A. Rate of interest: 0
	B. An AssertionError is thrown.
	C. No interest for this account
	D. A compilation error occurs at line n1.
	
	Answer: B
	
	- If you are using eclipse editor, you should add -ea in vm argument.
	
	Exception in thread "main" java.lang.AssertionError: No interest for this account
		at com.wealth.certificate.dumps_1z0_809.question097.RateOfInterest.main(RateOfInterest.java:15)

     */
}


public class AssertTest3 {

	
	public static void main(String[] args) {
		
		
	}
}
