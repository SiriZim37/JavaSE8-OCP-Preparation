package ocp;

public class Enum1 {
	  enum Roman {I, V, X, L, C, M }
	  
	  public static void main(String... bang) {
		    int x = 7;
		    int z = 2;
		    Roman r = Roman.X;
		    do {
		      switch (r) {
		        case C: r = Roman.L; break;
		        case X: r = Roman.C;
		        case L: if (r.ordinal() > 2) z+= 5;
		        case M: x++;
		      }
		      z++;
		    } while (x < 10);
		    System.out.println(z);
		  }
}

