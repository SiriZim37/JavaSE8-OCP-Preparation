package streams.wdh;


import java.util.stream.Stream;

public class B07_intermediate_distinct {

	/*
	 *     Stream<T> distinct();
	 */
	public static void main(String[] args) {
	
		/*
		 * Bsp.1 
		 * 
		 * vorher : 1,2,1,3,1
		 * nacher : 1 2 3
		 */
		Stream.of(1,2,1,3,1)
			  .distinct()
			  .forEach(System.out::print);
		 
		System.out.println();
		
		/*
		 * Bsp 2.
		 * 
		 * unterschidliche Referenz Addresse und HashCode
		 * 1 : streams.wdh.B07_intermediate_distinct$Blume@4c75cab9
		 * 2 : streams.wdh.B07_intermediate_distinct$Blume@c39f790
		 * 1 : streams.wdh.B07_intermediate_distinct$Blume@71e7a66b
		 * 3 : streams.wdh.B07_intermediate_distinct$Blume@2ac1fdc4
		 * 1 : streams.wdh.B07_intermediate_distinct$Blume@5f150435
		 * 
		 * Returns a stream consisting of the distinct elements 
		 * (according to Object.equals(Object)) of this stream. 
		 */
		Stream.of(new Blume(1) , new Blume(2) , new Blume(1) ,new Blume(3) ,new Blume(1) )
				.distinct()
				.map( b -> b.preis + " : " + b)
				.forEach(System.out::println);
	
		System.out.println();
		
		/*
		 * Bsp.3
		 * 
		 * mit den  boolean equals(Object obj) ,  int hashCode() Methoden.
		 * 
		 * 1 : streams.wdh.B07_intermediate_distinct$Blume@1
		 * 2 : streams.wdh.B07_intermediate_distinct$Blume@2
		 * 3 : streams.wdh.B07_intermediate_distinct$Blume@3
		 */
		
		Stream.of(new Blume(1) , new Blume(2) , new Blume(1) ,new Blume(3) ,new Blume(1) )
		.distinct()
		.map( b -> b.preis + " : " + b)
		.forEach(System.out::println);
		
		
	}// end of main

	static class Blume{
		int preis;
		public Blume(int preis) {
			this.preis = preis;
		}

		public boolean equals(Object obj) {
			return ((Blume)obj).preis == preis;
		}
		
		public int hashCode() {
			return preis;
		}
		
	}
}
