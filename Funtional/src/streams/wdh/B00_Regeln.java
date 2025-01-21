package streams.wdh;

import java.util.stream.Stream;

public class B00_Regeln {

	public static void main(String[] args) {
		/*
		 * Nur eine Terminal Operation aktiviert die Pipeline!
		 */
		Stream.of(1, 2, 3)
			.peek(x -> System.out.print(x)); // keine Ausgaben

	}

}
