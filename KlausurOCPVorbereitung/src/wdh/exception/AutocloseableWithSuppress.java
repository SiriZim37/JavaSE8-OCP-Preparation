package wdh.exception;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

public class AutocloseableWithSuppress {

	public static void main(String[] args) {

		b1();
		System.out.println("\n");
		
		b2();
		System.out.println("\n");
		
		b3();
		System.out.println("\n");
		
		b4();
		System.out.println("\n");
		
		b5();
		System.out.println("\n");
		
		b6();
		
	}
	//-----------------------------------------------
	static class R7 implements AutoCloseable{
		@Override
		public void close() {
			throw new RuntimeException("Suppressed ex7 aus close ");
		}
	}

	private static void b6()  {
		try (R7 r = new R7(); ) {
			throw new RuntimeException("ex7 aus try ");
		}
		/*
		 * RuntimeException: ex7 aus try 
		 * Suppressed: java.lang.RuntimeException: Suppressed ex7 aus close 
		 */
	}
	
	//-----------------------------------------------

	static class R6 implements AutoCloseable{
		int index;
		public R6(int index) {
			this.index = index;
		}
		@Override
		public void close() {
			throw new RuntimeException("ex6 aus close " + index);
		}
	}

	private static void b5()  {
		try (R6 r1 = new R6(1); 
				R6 r2 = new R6(2); ) {
			throw new RuntimeException("ex6 aus try "); 
		}
		/*
		 * RuntimeException: ex6 aus try 
		 * Suppressed: java.lang.RuntimeException: ex6 aus close 2
		 * 	Suppressed: java.lang.RuntimeException: ex6 aus close 1
		 */
	}
	
	//-----------------------------------------------
	
	static class R4 implements AutoCloseable{
		@Override
		public void close() throws Exception {
			throw new RuntimeException("ex4 aus close");
		}
	}
	static class R5 implements AutoCloseable{
		@Override
		public void close() throws Exception {
			throw new RuntimeException("ex4 aus close");
		}
	}
	private static void b4(){
		try (R4 r1 = new R4(); 
					R5 r2 = new R5(); ) {
			throw new RuntimeException("ex4 aus try");
		}catch (Exception e) {
			System.out.println(e);	// java.lang.RuntimeException: ex4 aus try
			Throwable[] supperessd = e.getSuppressed();
			for (Throwable t : supperessd) {
				System.out.println(t);
			}
			/*
			 * java.lang.RuntimeException: ex4 aus try
			 * Suppressed: java.lang.RuntimeException: ex4 aus close
			 * Suppressed: java.lang.RuntimeException: ex4 aus close
			 */
			
		}
	}
	
	
	//-----------------------------------------------
		static class R3 implements AutoCloseable{
			@Override
			public void close() throws Exception {
				throw new RuntimeException("ex3 aus close");
				
			}
		}
		private static void b3() {
			try (R3 r = new R3();) {
				throw new RuntimeException("ex3 aus try");
			}catch (Exception e) {
				System.out.println(e);	// .RuntimeException: ex3 aus try
			}
		}
		
	//-----------------------------------------------
	static class R2 implements AutoCloseable{
		@Override
		public void close() throws Exception {
			throw new RuntimeException("ex2 aus close");
			
		}
	}
	private static void b2() {
		try (R2 r = new R2();) {
	
		}catch (Exception e) {
			System.out.println(e);	// RuntimeException: ex2 aus close
		}
	}
	//-----------------------------------------------
	
	static class R1 implements AutoCloseable{
		@Override
		public void close() throws Exception {
			System.out.println("e2");
		}
	}

	private static void b1() {
		try (R1 r = new R1();) {
			throw new RuntimeException("c1");
		}catch (Exception e) {
			System.out.println(e);	// e2 ,  java.lang.RuntimeException: c1
		}
	}

}
