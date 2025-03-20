package kontrollstruckturen;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DoWhileSchleife {

	public static void main(String[] args) {
		
		// 0 1 2
		int x1 = 0;
		do {
			System.out.print(x1 + " ");
			x1++;
		} while ( x1<3 ) ; // Semikolon!
		System.out.println();

		// 0 1 2
		int x2 = 0;
		do {
			System.out.print(x2++ + " ");
		} while ( x2<3 ) ;
		System.out.println();
		
		
		/*
		 * do-while in der Praxis
		 */
		Path p = Paths.get(".").toAbsolutePath().normalize();
		
		do {
			System.out.println(p);
			p = p.getParent();
			
		} while(p != null);
		
	}

}
