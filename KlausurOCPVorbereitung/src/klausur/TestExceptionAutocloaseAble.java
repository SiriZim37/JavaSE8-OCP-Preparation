package klausur;


/*
   public class Test implements AutoCloseable {
    private int index;
    
    public Test(int index) {
      this.index = index;
      System.out.print(index + " ");
    }

    public void close() {
      System.out.print(index + " ");
    }
    
    public static void main(String[] args) {
      try (Test t1 = new Test(1);
          Test t2 = new Test(2)) {;
      } finally {
          System.out.print(3 + " ");
      }
    }
  }

Was ist richtig?

[   ] 3 1 2 2 1
[   ] 3 1 2 1 2
[ X ] 1 2 2 1 3
[   ] 1 2 1 2 3
 */
public class TestExceptionAutocloaseAble implements AutoCloseable {
	
		    private int index;
		    
		    public TestExceptionAutocloaseAble(int index) {
		      this.index = index;
		      System.out.print(index + " ");
		    }

		    public void close() {
		      System.out.print(index + " ");
		    }
		    
		    public static void main(String[] args) {
		      try (TestExceptionAutocloaseAble t1 = new TestExceptionAutocloaseAble(1);
		    		  TestExceptionAutocloaseAble t2 = new TestExceptionAutocloaseAble(2)) {;
		      } finally {
		          System.out.print(3 + " ");
		      }
		    }
}


