package ocp;

class ExceptionAutoCloasable3 {
	 static class A implements AutoCloseable {
	        @Override
	        public void close() throws Exception {
	            // Throw an exception when closing
	            throw new Exception("catch");
	        }
	    }

	    private static void method() throws Exception {
	        try (A a = new A()) {
	            // Throw an exception inside the try block
	            throw new Exception("try");
	        }
	    }

	    public static void main(String[] args) {
	        try {
	            method(); // Call the method that triggers multiple exceptions
	        } catch (Exception e) {
	            // Combine primary and suppressed exception messages
	            String output = e.getMessage() + " " + e.getSuppressed()[0].getMessage();
	            System.out.println(output);
	        }
	    }
}
