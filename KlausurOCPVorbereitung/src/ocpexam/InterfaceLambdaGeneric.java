package ocpexam;


interface Box<T, B> {
    T apply(T x);
    B multiply(B x);
}

public class InterfaceLambdaGeneric {

	public static void main(String[] args) {
		
		 Box<Integer, String> intStringBoxA = new Box<Integer, String>() {
	            @Override
	            public Integer apply(Integer x) {
	                return x * 2;
	            }

	            @Override
	            public String multiply(String x) {
	                return x + x;
	            }
	        };

//	    Box<Integer, String> lambdaBox = (x) -> x * 2;  // cf The target type of this expression must be a functional interface
//	    Box<String, String> lambdaMultiplyBox = (x) -> x + x;  //cf  The target type of this expression must be a functional interface

	        
	     ///////////////////////////////////////////////
	    
	    // Anonymous class implementation
        Box<Integer, String> intStringBoxB = new Box<Integer, String>() {
            @Override
            public Integer apply(Integer x) {
                return x * 2;
            }

            @Override
            public String multiply(String x) {
                return x + x;
            }
        };

        // Testing the Box interface
        System.out.println(intStringBoxB.apply(5));  // Output: 10
        System.out.println(intStringBoxB.multiply("Hello"));  // Output: HelloHello
       
	}
}


