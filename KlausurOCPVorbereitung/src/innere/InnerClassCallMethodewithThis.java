package innere;

public class InnerClassCallMethodewithThis {

	class Engine{
		{
			InnerClassCallMethodewithThis.this.drive(); // ok
//			this.drive()// cf : The method drive() is undefined for the type InnerClassCallMethodewithThis.Engine
		}
		public Engine() {
			InnerClassCallMethodewithThis.this.drive(); // ok
//			this.drive()// cf : The method drive() is undefined for the type InnerClassCallMethodewithThis.Engine
		}
	}
	
	public static void main(String[] args) {
		new InnerClassCallMethodewithThis().go();
	}
	void go() { new Engine(); }
	
	void drive() {
		System.out.println("hi");
	}
}
