package sortieren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B01_SortierenInDerStandardbibliothek {

	public static void main(String[] args) {
		
		/*
		 * primitiv in array
		 */
		int[] a1 = { 7,-2 ,5 ,3 };
		Arrays.sort(a1);
		System.out.println("a1: " + Arrays.toString(a1));	// a1: [-2, 3, 5, 7]
		
		
		/*
		 * List sort
		 */
		List<Integer> listA1 = new ArrayList<Integer>(Arrays.asList( 7,-2 ,5 ,3 ));
		Collections.sort(listA1);
		Collections.sort(listA1 , Comparator.naturalOrder());
		System.out.println("listA1: " + listA1);	
		
		Comparator<Integer> reverseCmp = (i1,i2) -> i2-i1;
		listA1.sort(reverseCmp);
		System.out.println("listA1 reverse: " +listA1);	
		
		/*
		 * String in array
		 */
		String[] a11 = { "gg","cc","ahh","kkk" };
		Arrays.sort(a11);
		System.out.println("a11: " + Arrays.toString(a11));	//  [ahh, cc, gg, kk]
		
		Comparator<String> cmpStr = Comparator.comparingInt(String::length);
		Arrays.sort(a11,cmpStr);
		System.out.println("a11: " + Arrays.toString(a11));	//   [cc, gg, ahh, kkk]
		
		
		//-------------------------------------------------------------// 
		/*
		 * Array mit Referenz 
		 */
		
		class Foo{
			int a , b;
			public Foo(int a , int b) {
				this.a = a;
				this.b = b;
			}
		}
		
		Foo[] a2 = {
			new Foo(1,10),
			new Foo(2,9),
			new Foo(3,8),
			new Foo(4,7),			
		};
		
		try {
			Arrays.sort(a2);  // Exception : Cant sort >   java.lang.ClassCastException : no comparable implementiert 
			System.out.println("a2: " + Arrays.toString(a2) );  
		} catch (Exception e) {
			System.out.println(e);
		}
	
		
		/*
		 * Lösung A
		 * sort für Comparable
		 */
		class Foo2 implements Comparable<Foo2>{
			int a , b;
			public Foo2(int a , int b) {
				this.a = a;
				this.b = b;
			}
			public int compareTo(Foo2 o) {
				if (this.a != o.a) {
			       return Integer.compare(this.a, o.a);
			    }
			    return Integer.compare(this.b, o.b);    
			};
			@Override
			public String toString() {
				return "(" + a + "/ " + b + ")";
			}
		}
		
		Foo2[] a3 = {
			new Foo2(1,10),
			new Foo2(2,9),
			new Foo2(3,8),
			new Foo2(4,7),			
		};
		System.out.println("a3: " + Arrays.toString(a3) );   // [(1/ 10), (2/ 9), (3/ 8), (4/ 7)]
	
		/*
		 * LösungB
		 * sort mit Comparator
		 */
		System.out.println("\n*** sort , die Comparator verwendet");
		Comparator<Foo2> myCmp = ( x , y) -> { return y.compareTo(x); };
		Arrays.sort(a3,myCmp);
		
		System.out.println("a3: " + Arrays.toString(a3) );  // [(4/ 7), (3/ 8), (2/ 9), (1/ 10)]
	}
}
