package kontrollstruckturen;

import java.util.ArrayDeque;
import java.util.Queue;

public class WhileSchleifen {

	public static void main(String[] args) {
		
		// 0 1 2
		int x = 0;
		while(x < 3) {
			System.out.print(x + " ");
			x++;
		}
		System.out.println();

		// 0 1 2
		int x2 = 0;
		while(x2 < 3) {
			System.out.print(x2++ + " ");
		}
		System.out.println();
		
		// 1 2 3
		int x3 = 0;
		while(x3 < 3) {
			System.out.print(++x3 + " ");
		}
		System.out.println();
		
		/*
		 * while in der Praxis.
		 * 
		 */
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(12);
		queue.add(13);
		queue.add(14);
		
		while(!queue.isEmpty()) {
			System.out.println( queue.poll() );
		}
		
	}

}
