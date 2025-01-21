package aufgaben.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ArrayListPositive extends ArrayList<Integer> {
	 
	public boolean add(Integer n) {
		validate(n);
		return super.add(n);
	}
	
	public void add(int index, Integer n) {
		validate(n);
		super.add(index, n);
	}

	public Integer set(int index, Integer n) {
		validate(n);
		return super.set(index, n);
	}
	

    public boolean addAll(Collection<? extends Integer> n) {
        for (Integer value : n) {
            validate(value); 
        }
        return super.addAll(n); 
    }

	

	public boolean addAll(int index, Collection<? extends Integer> n) {
		for (Integer value : n) {
            validate(value); 
        }
		return super.addAll(index, n);
	}
	
	
	private void validate(Integer value) {
		

//		System.out.println("check assert");	 
//		assert value != null : "Null ist ungültig";  		 // Check not null
//		assert value != 0 : "0 Wert ist ungültig";			 // Check 0 
//	    assert value > 0 : "Negative Wert ist ungültig";     // Check positive value	    

			
		if(value == null) {
			throw new NullArgumentException("Null ist ungültig");
		}
			
		if(value == 0) {
			throw new NotPostivieArgumentException("0 Wert ist ungültig");
		}
			
		if(value < 0) {
			throw new NotPostivieArgumentException("Negative Wert ist ungültig");
		}
		
	}
	
}

class NullArgumentException extends RuntimeException { 
	
    public NullArgumentException(String message)  {
        super(message);
    }
}

class NotPostivieArgumentException  extends RuntimeException {
	
    public NotPostivieArgumentException(String message) {
    	 super(message);
    }
}

