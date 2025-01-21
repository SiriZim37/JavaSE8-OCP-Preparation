package inner;

import java.util.Arrays;
import java.util.Comparator;


/*
 * 	1. Toplevel-Klasse definieren
 */
class ToplevelCmp /*extends Object*/ implements Comparator<Integer>{
	
	/*
	 * ToplevelCmp(){
	 * 		super();
	 * }
	 */
	public int compare(Integer x, Integer y) {

		return x-y;
	}
}

public class B06_AnnonymeKlasse {

	/*
	 * 1. innere Klasse definieren
	 */
	
	class  InnerCmp /*extends Object*/  implements Comparator<Integer>{
		public int compare(Integer x, Integer y) {

			return x-y;
		}
	}
	
	static class InnerCmpStatic /*extends Object*/  implements Comparator<Integer>{
		public int compare(Integer x, Integer y) {

			return x-y;
		}
	}
	public static void main(String[] args) {

		/*
		* 2. Toplevel-Klasse instanzieren
		*/
		Comparator<Integer> c1 = new ToplevelCmp();
		
		/*
		 * 2. Innere Klasse instanzieren
		 */

//		Comparator<Integer> c2 = new Innnercmp(); // cf   Cannot call not static methode
//		Comparator<Integer> c2 = this.new Innnercmp(); // Cannot use this in a static context
		
		Comparator<Integer> c2 = new B06_AnnonymeKlasse().new InnerCmp();  // ok
		
		Comparator<Integer> c3 = new InnerCmpStatic(); // ok // static in staic 
		Comparator<Integer> c4 = new B06_AnnonymeKlasse.InnerCmpStatic(); // ok
		
		
		/*
		 * 1. lokale Klasse definieren
		 */
		class LocalCmp /*extends Object*/  implements Comparator<Integer>{  /* keine Sichtbarkeit */
			/*
			 * LocalCmp
			 */
			public int compare(Integer x, Integer y) {
				return x-y;
			}
		}
		
		/*
		 * 2. lokale Klasse instanzieren
		 */	
		Comparator<Integer> c5 = new LocalCmp();
		
		
		/*
		 * 1.+2. annonyme Klasse definieren und sofort instantzieren
		 */
		new Comparator<Integer>(){
			public int compare(Integer x, Integer y) {
				return x-y;
			}
		};
		
		/*
		 * 1.+2. mit einer Lambda
		 */
		Comparator<Integer> c6 = (Integer x , Integer y) ->{
			return x-y;
		};
		
		/*
		 * Comparator weiter verwenden
		 */
		Integer[] arr = {1,2,3,4,5,6,};
		Arrays.sort(arr, new ToplevelCmp());
		Arrays.sort(arr, new B06_AnnonymeKlasse().new InnerCmp());
		Arrays.sort(arr, new InnerCmpStatic());
		Arrays.sort(arr, new LocalCmp());
		
		Arrays.sort(arr , new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return x-y;
			}
		});
		
		Arrays.sort(arr, (Integer x , Integer y) ->{
			return x-y;
		});
		
		Arrays.sort(arr , (x , y) -> x-y);
		
		
		
		
	}// end of main

}
