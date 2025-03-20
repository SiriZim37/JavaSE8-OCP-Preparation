package ocpexam;


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
                assert false: "No interest for this account"; //line n1 
        } 
        System.out.println("Rate of interest: " + rateOfInterest); 
    }
    /*
		Given:
		
		and the command:
		
		java –ea RateOfInterest
		
		What is the result?
		
		A. Rate of interest: 0
		
		B. An AssertionError is thrown.
		
		C. No interest for this account
		
		D. A compilation error occurs at line n1.
		
		
		
		Option Breakdown:
		A. Rate of interest: 0: Incorrect. This would be the case if assertions were disabled, but since we're using -ea to enable assertions, an exception will be thrown instead.
		
		B. An AssertionError is thrown: Correct. Assertions are enabled, so an AssertionError is thrown at line n1 with the message "No interest for this account".
		
		C. No interest for this account: Incorrect. This is part of the assertion error message, but the actual result is an exception being thrown, not just this message being printed.
		
		D. A compilation error occurs at line n1: Incorrect. There is no compilation error. The syntax is correct, but an exception will occur when running the code.
		
		
		Correct Answer: B. An AssertionError is thrown.
		
		This is the correct answer because with assertions enabled (-ea), 
		the assertion at line n1 fails, and an AssertionError is thrown.

     */
}


public class AssertSwitchTest1 {

	
	public static void main(String[] args) {
		
		
	}
}
