package oca;


class NormalBase{
	private void m1() {}	// für andere nicht sichtbar // Not inheritance
	private void m2() {}	// für andere nicht sichtbar // Not inheritance
}

class NormalDervied extends NormalBase{
	private void m1() {}	// ok  Not Overloading methode
	void m2() {}			//ok  Not Overloading methode
}

public class PolymorphieGibtesNurWennUeberschreibenMoeglichIst {

	static class InnerClass{
		private void m1() { System.out.println("base/m1");}				// Not inheritance
		private void m2() { System.out.println("base/m1");}         	// Not inheritance
	}
	
	static class InnerDervied extends InnerClass{
		public void m1() {}										// ok
		//private void m1() { System.out.println("dervied/m1");}	// ok Not Overloading methode because m1() base is private
		void m2() {System.out.println("dervied/m2");}			// Not Overloading methode because m1() base is private
	}
	
	public static void main(String[] args) {
//		?????????????????????
		
		InnerClass n1 = new InnerDervied();
		System.out.println();
	}
}
