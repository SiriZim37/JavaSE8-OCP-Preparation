package ocpexam;

public class InnerClassLocalMethode {

		
	class B{
		int x = 0;
		
		void methodeA() {
			int y = 0;
			
			class UB{
				int z = 0;
				
				void testMethode() {
					z = x + y;
//					y = z+x;	// cf
				}
			}
		}

	}
}
