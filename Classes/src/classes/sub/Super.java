package classes.sub;



public class Super {

	private int privateInt = 42;
	int defaultInt = 43;
	protected int protecedInt = 44;
	public int publicInt = 45;
	
	protected void  testProtected() {
		System.out.println(protecedInt);
	};
}

class Sub extends Super{
	
	public void print() {
		
//		System.out.println(privateInt); : cf 
		System.out.println(defaultInt);
		System.out.println(protecedInt);
		System.out.println(publicInt);
	}
}

class Test{
	
	public void print() {
		Super sup = new Super();
//		System.out.println(sup.privateInt); 
		System.out.println(sup.defaultInt);
		System.out.println(sup.protecedInt);
		System.out.println(sup.publicInt);
	}
}
