package wdh.inheritance;

public class MethodeAnrufen {

	
	interface MyInterface{
		static void staticMethodeA() {}
		
		default void innerhalbDesInterface() {
			staticMethodeA();                  // instance call call static
		}
		
		void instanceMethodeA();
		void instanceMethodeB();
	}
	
	static class BaseClass{
		static void staticMethodeB() {}
		
		void innerhalbDerKlass(){
			staticMethodeB();
		}
	}
	
	static class SubClass extends BaseClass implements MyInterface{
		// can call static & non static 
		void innerhalbDerKlass() {
			
			staticMethodeB();
			BaseClass.staticMethodeB();
			super.innerhalbDerKlass();
//			BaseClass.innerhalbDerKlass();				// cf : cannt access non-static methode with static 
			
			MyInterface.staticMethodeA();
//			MyInterface.super.staticMethodeA();			// cf : Static methode cannt acces with super
			MyInterface.super.innerhalbDesInterface();
			innerhalbDesInterface();
			
//			this.staticMethodeA();						   // cf : No staticMethodeA in SubClass
			this.staticMethodeB();
			SubClass.this.staticMethodeB();
			
			this.innerhalbDerKlass();						// aus SubClass
			SubClass.this.innerhalbDerKlass();				// aus SubClass
			
			super.innerhalbDerKlass();						// aus BaseClass
			SubClass.super.innerhalbDerKlass();				// aus BaseClass
			
			this.innerhalbDesInterface();					// aus Innterface
			SubClass.this.innerhalbDesInterface();			// aus Innterface
			
			instanceMethodeA();
			instanceMethodeB();
			this.instanceMethodeA();
			this.instanceMethodeB();
			SubClass.this.instanceMethodeA();
			SubClass.this.instanceMethodeB();
			
		}

		@Override
		public void instanceMethodeA() {
			System.out.println("instanceMethodeA aus SubClass");
			
		}

		@Override
		public void instanceMethodeB() {
			System.out.println("instanceMethodB aus SubClass");
			
		}
		
		
		
		
	}
}
