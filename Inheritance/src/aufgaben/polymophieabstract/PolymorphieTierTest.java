package aufgaben.polymophieabstract;

public class PolymorphieTierTest {

	public static void main(String[] args) {
		
		Hund h1 = new Hund("Rex", 3, true);
		Katze c1 = new Katze("Tom", 1, false);

		h1.laufen();
		c1.laufen();
		
		Tier t1 ;
		t1 = h1;
		t1.laufen();
		
		t1 = c1;
		t1.laufen();
		
		print(h1);
		print(c1);
	}
	
	
	
	
	static void print(Tier tier) {
		
		tier.print();
		
//		if (tier instanceof Hund) {
//		    System.out.println("Hund. Name: " + tier.getName());
//		} else if (tier instanceof Katze) {
//	        System.out.println("Katze. Name: " + tier.getName());
//	    }
	}
	
	


}
