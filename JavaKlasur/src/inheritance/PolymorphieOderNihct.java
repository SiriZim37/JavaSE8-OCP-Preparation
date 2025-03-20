package inheritance;

public class PolymorphieOderNihct {
	
		
//?????????????????????????????????????????
	static class Tier{
		static int Maxalter = 1000;
		
		public static int getMaxAlter() {
			return Maxalter;
		}
		
		int alter = 11;
		public  int getAlter() {
			return alter;
		}
	}
	
	static class Hund extends Tier{
		static int Maxalter = 2000;
		
//		static int getMaxAlter() {		// overload cannot reduce the visibility of the inherited
//			return Maxalter;
//		}
		public static int getMaxAlter() {		
			return Maxalter;
		}
		
		int alter = 20;
		public  int getAlter() {
			return alter;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(Tier.Maxalter);
		System.out.println(Tier.getMaxAlter());
		
		System.out.println("-----------------------------");
		Tier t =  null;
		System.out.println(t.getMaxAlter());
		try {
			System.out.println(t.alter);
			System.out.println(t.getAlter());
		} catch (Exception e) {
			System.out.println(e);
		}

		t = new Tier();
		System.out.println(t.getMaxAlter());
		System.out.println(t.alter);
		System.out.println(t.getAlter());
		
		
		
		//--------------------------------------------------------------
		
		System.out.println("-----------------------------");
		
		Tier h = new Hund();
		
		System.out.println(h.Maxalter);
		System.out.println(h.getMaxAlter());	// static aus Tier

		System.out.println(h.alter);			
		System.out.println(h.getAlter());		// 20 aus Hund : only methode Polymorphie 
		
		
		//--------------------------------------------------------------
		
		System.out.println("------------------------------------");
		/*
		 * Casting
		 */
		
		Hund v1 = new Hund();
		Tier v2 = new Hund();
		Tier v3 = new Tier();
//		Hund v4 = new Tier(); 	// cf 
//		Hund v5 = v2; 			// cf
		
		System.out.println("\nv6");
		Hund v6 = (Hund)v2; 			
		System.out.println(v6.alter);			// 20 aus Hund
		System.out.println(v6.Maxalter);		// 2000 aus Hund
		System.out.println(v6.getAlter());		// 20 aus Hund
		System.out.println(v6.getMaxAlter());	// 2000 aus Hund
		
		System.out.println("\nv7");
		Tier v7 = v2; 		    
		System.out.println(v7.alter);			// 11 aus Tier
		System.out.println(v7.Maxalter);		// 1000 aus Tier
		System.out.println(v7.getAlter());		// 20 aus Hund
		System.out.println(v7.getMaxAlter());	// 2000 aus Hund
		
		System.out.println("\nv8");
		Tier v8 = new Hund();
		System.out.println( v8.alter);					// 11 aus Tier
		System.out.println( ((Hund) v8).alter);			// 20 aus Hund
		System.out.println( v8.getAlter());				// 20 aus Hund
		System.out.println( ((Hund) v8).getAlter());	// 20 aus Hund
		
		System.out.println("\nv8");
		Hund v9 = new Hund();
		System.out.println( ((Tier)v9).alter);				// 11 aus Tier
		System.out.println( ((Tier)v9).getAlter());			// 20 aus Tier
		System.out.println( ((Tier)v9).Maxalter);			// 1000 aus Tier
		System.out.println( ((Tier)v9).getMaxAlter());		// 1000 aus Tier
		
		Tier v10 = new Tier();
		System.out.println( ((Hund)v10).alter);			// java.lang.ClassCastException	
		
	}
}
