package ocpexam;

import java.util.*;

class BoxAA<T> {
    private T value;

    public BoxAA(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}


public class GenericDownCasting {

	public static void main(String[] args) {
		
		 List<BoxAA<?>> list = new ArrayList<>();
	        
	        list.add(new BoxAA<Integer>(10));
	        list.add(new BoxAA<String>("Hello"));
	        
	        for (BoxAA<?> box : list) {
	        	BoxAA<Integer> intBox = (BoxAA<Integer>) box;  // Downcasting
	            System.out.println(intBox.getValue());
	        }
	  }
	
	/*
	 
	 	Options:
		a) Compilation Error
		b) 10, Hello
		c) ClassCastException
		d) 10, 10
		
		
		
		
		Answer Explanation:
		List<Box<?>> list = new ArrayList<>();
		
		A List of Box<?> is declared. The ? means it can store any type of Box, such as Box<Integer> or Box<String>, but the specific type will be determined at runtime.
		list.add(new Box<Integer>(10));
		
		A Box<Integer> is added to the list with the value 10.
		list.add(new Box<String>("Hello"));
		
		A Box<String> is added to the list with the value "Hello".
		for (Box<?> box : list)
		
		The list is iterated, and each element is a Box<?>, which means it can hold any type of object, but the actual type is not known at compile time.
		Box<Integer> intBox = (Box<Integer>) box;
		
		This line involves downcasting. The code attempts to cast the Box<?> to a Box<Integer>, but this cast is not safe because the actual object in box could be a Box<String> or any other type. This will result in a ClassCastException at runtime when it tries to cast Box<String> to Box<Integer>.
		Output:
		
		
		
		Since the downcast is invalid (because not all elements in the list are of type Box<Integer>), a ClassCastException will be thrown when trying to cast the second element (Box<String>) to Box<Integer>.
		Correct Answer:
		c) ClassCastException


	 */
}
