package wdh.inheritance;


class NormalBase{
	private void m1() {}	// für andere nicht sichtbar // Not inheritance
	private void m2() {}	// für andere nicht sichtbar // Not inheritance
	void m3() {}
	private  void m55() {}
}

class NormalDervied extends NormalBase{
	public void m1() {}				// ok  Not Overloading methode
	private void m2() {}			//ok  Not Overloading methode
	public void m55() {}
}

public class PolymorphieGibtesNurWennUeberschreibenMoeglichIst extends NormalDervied{

//	private void m1() {}	// cf : m1 aus NormalDervied Cannot reduce the visibility of the inherited method from NormalDervied
	
	static class InnerClass{
		private void m1() { System.out.println("base/m1");}				// Not inheritance
		private void m2() { System.out.println("base/m1");}         	// Not inheritance
	}
	
	static class InnerDervied extends InnerClass{
		private void m1() { System.out.println("dervied/m1");}	// Not Overloading methode because m1() base is private
		void m2() {System.out.println("dervied/m2");}			// Not Overloading methode because m1() base is private
		public void m55() {}
	}
	
	public static void main(String[] args) {
//		?????????????????????

		InnerClass n1 = new InnerDervied();
		System.out.println();
//		NormalBase.m1();

		new PolymorphieGibtesNurWennUeberschreibenMoeglichIst().go();
	}
	void go() {
//		NormalDervied.m2();
		this.m3();
		super.m3();
		PolymorphieGibtesNurWennUeberschreibenMoeglichIst.this.m3();
//		PolymorphieGibtesNurWennUeberschreibenMoeglichIst.this.m2(); 
	}

}
