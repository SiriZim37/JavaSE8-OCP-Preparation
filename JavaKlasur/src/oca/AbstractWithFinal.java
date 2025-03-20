package oca;

public class AbstractWithFinal {

//	abstract final class c2{}		// cf 
	
   private abstract class c2{}			// abstract class - private >  OK 
   										// da die Klasse doch innerhalb der äußeren Klasse sichtbar ist
   										// und kann erweitern werden
	
   abstract class MyClass{
	   									// abstract Methode - private oder final  > Geht NICHT! 
	   									//, da die private methode nicht vererben werden
//	   final abstract void m1();		// cf : es kann nicht vererben
//	   private abstract void m2(); 		// cf : es kann nicht vererben
	   protected abstract void m3();
	   public abstract void m4();
	   abstract void m5();
	   
	   // nur concreat methode
	   private final void m6() {}		// ok - not abstract 
	   final void m7() {}				// ok - not abstract 
	   private void m8() {}				// ok - not abstract 
	}
	
}
