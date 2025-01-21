package func;

public class B06_LambdasHabenKeineThis {


	/*
	 * Unwahrscheinlich in der Prüfung
	 */
	public static void main(String[] args) {

		/*
		 * Lambda hat keine eigene this
		 */
		Runnable  v1= () ->{
//			System.out.println(this); 	//cf :  keine this in Lamda
//			toString(); 				// cf : keine this in Lamdafür this.toString()
		};
		
		// Zum Vergleich . anonyme Klasse 
		
		Runnable v2 = new Runnable() {
			public void run() {				// annonyme Klass zurück
				System.out.println(this); 
			}
		};
		System.out.println("main");
		System.out.println(v1.getClass()); // class func.B06_LambdasHabenKeineThis$$Lambda/0x0000000800000a00
		System.out.println(v2.getClass()); // class func.B06_LambdasHabenKeineThis$1

	} // end of main
	
	/*
	 * Achtung ! 
	 * Eine Instazmethode hat eigene this (this der umschließenden Klasse)
	 */
	
	void m() {
		Runnable r1 = ()->{
			System.out.println(this); // das ist die this m() 
		};
		System.out.println(this);     // die this aus m()
	}
	
	

}
