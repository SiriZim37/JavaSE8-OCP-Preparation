package exeptions;



class MeineResB implements AutoCloseable{
	public MeineResB() {
		System.out.println("Open B");
	}
	
	public void close() {
		System.out.println("close B");
	}
}

class MeineResC implements AutoCloseable{
	public MeineResC() {
		System.out.println("Open C");
	}
	
	public void close() {
		System.out.println("close C");
	}
}

public class B13_try_with_resources_und_mehrere_ressourcen {


	public static void main(String[] args) {
		
		System.out.println("*** Bsp. 1");
		/*
		 * Achtung! 
		 * 
		 * Die Ressourcen werden in der umgekehrten Reihenfolge geschlossen!
		 * 
		 * Ausgaben : 
		 * 				Open B
		 * 				Open C
		 * 				close B
		 */
		try (MeineResB rB = new MeineResB()){
			MeineResC rC = new MeineResC();
		}
		
		
		System.out.println("\n*** Bsp. 2");
		/*
		 * Achtung ! 
		 * Keine weieren Anweisungen in den Runden Klammern! 
		 * 
		 * Ausgaben :  
		 * 				Open B
		 * 				Open C
		 * 				close C
		 * 				close B
		 * 
		 */
		
		try(MeineResB rB = new MeineResB();
//				System.out.println(" next ");  // cf 
				MeineResC rC = new MeineResC()) {
					
		}
		

	}

}
