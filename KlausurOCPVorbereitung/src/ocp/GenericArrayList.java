package ocp;

import java.util.ArrayList;

class Business{}
class Hotel extends Business{}
class Inn extends Hotel{}
public class GenericArrayList {

	ArrayList<Hotel> go (){
//		return new ArrayList<Inn>();  		// cf 
		return new ArrayList<Hotel>();  	// ok 
//		return new ArrayList<Business>();  	// cf 
	}
	
	ArrayList< ? extends Hotel> go2 (){
//		return new ArrayList<Inn>();  		// ok 
		return new ArrayList<Hotel>();  	// ok 
//		return new ArrayList<Business>();  	// cf 
	}
	
	ArrayList< ? super Hotel> go3 (){
//		return new ArrayList<Inn>();  		// cf 
//		return new ArrayList<Hotel>();  	// ok 
		return new ArrayList<Business>();   // ok 
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
