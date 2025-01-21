package klausur;


public class Test1 {
	   
	 Integer x;
	 Integer y;
	    
	    Test1(int x) {
	      this.x = this.y + x;
	    }
	  
	    public String toString() {
	      return String.valueOf(x + y);
	    }
	    
    public static void main(String... a) {
      System.out.println(new Test1(3));
    }
}
