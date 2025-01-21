package wdh.exception;

import java.io.Closeable;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class AutocloseableVSCloseable {

	public static void main(String[] args){
		
		AutoCloseable a = new AutoCloseable() {
			
			@Override
			public void close() throws Exception {						// ok 
				System.out.println("ac");
			}
//			@Override
//			public void close()  {										// ok 
//				System.out.println("ac");
//			}
	
//			@Override
//			public void close() throws NumberFormatException 
//										, RuntimeException {			// ok 
//				System.out.println("ac");
//			}
		};
		
		
		/*
		 * public interface Closeable extends AutoCloseable {
		 *   public void close() throws IOException;
		 * }
		 */
		java.io.Closeable c = new Closeable() {
			@Override
			public void close()  throws IOException{				// ok 
				System.out.println("c");
				
			}
			
//			@Override
//			public void close()  {									// ok 
//				System.out.println("c");
//				
//			}
			
//			@Override
//			public void close() throws Exception {	 //cf  Closeable erlaubt nur IOException Aber AutoCloseable kann throw alles
//				System.out.println("c");
//			}
		};
		
		
		
		//---------------------------------------------------------------------------------------------
		// test1 
		class TestAutoCloseable implements AutoCloseable{
			@Override
			public void close()  {
				throw new RuntimeException("R");
			}
		}

		//---------------------------------------------------------------------------------------------

	
			try {
				test2();
			} catch (Exception e) {

				e.printStackTrace();  // java.io.IOException  Suppressed: java.lang.RuntimeException: R
			}

	}
	
	static void test2 () throws Exception  {

		
		// test1 
		class TestAutoCloseable2 implements Closeable{
			@Override
			public void close()  {
				throw new RuntimeException("R");
			}
		}
		
		try (TestAutoCloseable2 t = new TestAutoCloseable2()){
			throw new IOException();
		} catch (Exception e) {
			throw e ;		// Exception in thread "main" java.lang.RuntimeException: R
		}
	}

	
}
