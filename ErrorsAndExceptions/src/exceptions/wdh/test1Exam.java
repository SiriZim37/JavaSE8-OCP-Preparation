package exceptions.wdh;


//Exam Test
class A extends Exception{
}

class B {
	
	B getA() throws A {
		throw new RuntimeException("B");
	}
}
	
		
public class test1Exam {

	public final test1Exam getA(){
		throw new RuntimeException("B");
	}
	
	public static void main(String[] args) {
		final test1Exam t = new test1Exam();
		t.getA();

	}

}
