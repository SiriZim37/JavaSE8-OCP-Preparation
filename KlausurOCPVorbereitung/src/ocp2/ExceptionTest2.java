package ocp2;

/*
 QUESTION 85
 Given:
 class UserException extends Exception    {  }
 class AgeOutOfLimitException extends UserException    {  }
 and the code fragment:
 class App  {
    public void doRegister(String name, int age)
        throws UserException, AgeOutOfLimitException  {
        if (name.length () < 6)  {
            throw new UserException ();
        } else if (age >= 60)   {
            throw new AgeOutOfLimitException ();
        } else {
            System.out.println(“User is registered.”);
        }
    }
    public static void main(String[ ] args) throws UserException  {
        App t = new App ();
        t.doRegister(“Mathew”, 60);
    }
 }
 What is the result?
 A. User is registered.
 B. An AgeOutOfLimitException is thrown.
 C. A UserException is thrown.
 D. A compilation error occurs in the main method.
 */

class UserException extends Exception    {  }
class AgeOutOfLimitException extends UserException    {  }

public class ExceptionTest2 {

	 public void doRegister(String name, int age)
		        throws UserException, AgeOutOfLimitException  {
		        if (name.length () < 6)  {
		            throw new UserException ();
		        } else if (age >= 60)   {
		            throw new AgeOutOfLimitException ();
		        } else {
		            System.out.println("User is registered.");
		        }
		    }
	 public static void main(String[ ] args) throws UserException  {
		 ExceptionTest2 t = new ExceptionTest2 ();
		        t.doRegister("Mathew", 60);
		    }
		    
}
