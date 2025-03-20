package aufgaben;

public class AufgabeKontrollstrukturenBreakContinueSimple {

	public static void main(String[] args) {
		a1();
		a2();
	}

	static void a2() {
		System.out.println("\n*** A2");
		
		for (int i = 0, countOutputs = 0; countOutputs<10; i++) {
			double value = Math.random();
			System.out.println("Versuch " + (i+1));
			
			if (value < 0.1 || value > 0.2) {
				continue;
			}
			
			countOutputs++;
			System.out.println(countOutputs + ". value = " + value);
		}
	}
		
	static void a1() {
		System.out.println("*** A1");
		
		int count = 0;
		while(true) {
			double value = Math.random(); // [0.0 .. 1.0)
			System.out.println(++count + ". value = " + value);
			
			if (value >= .1 && value <=.2) {
				break;
			}
		}
		
	}
	
}
