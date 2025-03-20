package exceptions.wdh;

public class WdhFinally1 {

	public static void main(String[] args) {

		int x = m();
		System.out.println(x);	// -7

	}
	
	static int m() {
		/*
		 * - return lädt 42 hoch
		 * - try-Block ist vorbei
		 * - finally-Block läuft
		 *  - return lädt -7 hoch 
		 *  - die methode ist beendet. 
		 */
		try {
			return 42;
		} finally {
			return -7;
		}
	}

}
