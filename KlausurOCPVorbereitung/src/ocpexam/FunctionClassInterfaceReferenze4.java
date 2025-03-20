package ocpexam;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Supplier;


public class FunctionClassInterfaceReferenze4 {

	public static int checkValue(String s1, String s2) {
		return s1.length() - s2.length();
	}
	public static void main(String[] args) {
		String[] strArray = new String [] {"Tiger", "Rat", "Cat", "Lion"};
		//line n1
		PersonFactory<PersonX> personFactory = PersonX::new;
		PersonX person = personFactory.create("Peter", "Parker");
		CheckClassFactory<CheckClass> chekcClass = CheckClass::new;
		Supplier<CheckClass> test = chekcClass::create;
		test.get();
		chekcClass.create();
		Arrays.sort(strArray, CheckClass :: checkValue); // A
		//Arrays.sort(strArray, (CheckClass::new)::checkValue); // B The target type of this expression must be a functional interface
		//Arrays.sort(strArray, (CheckClass::new).checkValue); // C The target type of this expression must be a functional interface
		//Arrays.sort(strArray, CheckClass :: new :: checkValue); // D The target type of this expression must be a functional interface
		for (String s : strArray) {
		System.out.print (s + " ");
		}
	}
		
}

class CheckClass {
	public static int checkValue (String s1, String s2) {
		return s1.length() - s2.length();
	}
}

interface CheckClassFactory<C extends CheckClass> {
	C create();
	
}


class PersonX {
    String firstName;
    String lastName;

    PersonX() {}

    PersonX(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}


interface PersonFactory<P extends PersonX> {
    P create(String firstName, String lastName);
}



/*
Given:
class CheckClass {
public static int checkValue (String s1, String s2) {
return s1 length() � s2.length();
}
}
and the code fragment:
String[] strArray = new String [] {"Tiger", "Rat", "Cat", "Lion"}
//line n1
for (String s : strArray) {
System.out.print (s + " ");
}
Which code fragment should be inserted at line n1 to enable the code to print Rat Cat Lion
Tiger?
A. Arrays.sort(strArray, CheckClass :: checkValue);
B. Arrays.sort(strArray, (CheckClass :: new) :: checkValue);
C. Arrays.sort(strArray, (CheckClass :: new).checkValue);
D. Arrays.sort(strArray, CheckClass :: new :: checkValue);
Answer: A
 */
