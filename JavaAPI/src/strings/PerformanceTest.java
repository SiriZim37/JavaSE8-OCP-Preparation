package strings;

public class PerformanceTest {

	public static void main(String[] args) {
		
		String s = "X";
		final int MAX = 250_000;
		long start = System.currentTimeMillis();
		for(int i = 0 ; i< MAX ; i++) {
			s += "X";
		}
		long ende = System.currentTimeMillis();
		System.out.println("Anzahl ms beim String : " + (ende - start));
//		System.out.println(s);
		
		
		StringBuilder sb = new StringBuilder("X");
		start = System.currentTimeMillis();
		for(int i = 0 ; i< MAX ; i++) {
			sb.append("X");
		}
		ende = System.currentTimeMillis();
		System.out.println("Anzahl ms beim StringBuilder : " + (ende - start));
		
		

		StringBuffer sbuf = new StringBuffer("X");
		start = System.currentTimeMillis();
		for(int i = 0 ; i< MAX ; i++) {
			sbuf.append("X");
		}
		ende = System.currentTimeMillis();
		System.out.println("Anzahl ms beim StringBuffer : " + (ende - start));
		
		
		System.out.println("Servus");
		
	}

}
