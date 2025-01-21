package innere;

public abstract class InnereKlassAbstract {
	
	public abstract String getName();
	
	public int getNum() {
		return 11;
	}
	
	public abstract class Bar{
		public int getNum(){
			return 22;
		}
	}
	
	public static void main(String[] args) {
		
//		InnereKlassAbstract a = new InnereKlassAbstract() {  // cf : getName() not implementiert wird
//			public int getNum() {
//				return 33;
//			}
//		};
		
		// Annonymous class with Polymorphie
		InnereKlassAbstract t = new InnereKlassAbstract() {
			public int getNum() {
				return 33;
			}

			@Override
			public String getName() {
				return "Tom";
			}
		};
		
		
		/*
		 * Note : // Inner-Class in Abstract dont need to implement abstract methode
		 */
		// Annonymous inner-class with Polymorphie
		InnereKlassAbstract.Bar f = t.new Bar() {   
			public int getNum(){
				return 44;
			}
		};
		
		System.out.println(f.getNum() + " " + t.getNum() + "("+ t.getName() +")");
		
	   t.go();
	}
	
	
	
	class ConcreateClassInner{ public void printMessage() {
        System.out.println("Inside ConcreateClassInner, enclosing class name: " + InnereKlassAbstract.this.getName());
    	}
	}
	
	void go() {
		 ConcreateClassInner inner = this.new ConcreateClassInner(); // Using 'this.' to reference the current enclosing instance
	     inner.printMessage();
	}
}
