package aufgaben.lambdas.javatipps.v1;

import java.util.function.Predicate;

public class LambdasJavaTipp implements Thema {

	public static void main(String[] args) {
		
		
		JavaTipp[] arryTipps = 
		 { new JavaTipp("Mit dem Schlüsselwort 'implements' kann eine Klasse ein Interface realisieren", new int[]{ VERERBUNG , KLASSEN , INTERFACES }) , 
		   new JavaTipp("Eine Klasse kann nur eine andere Klasse erweitern.", new int[]{VERERBUNG , KLASSEN }) ,
		   new JavaTipp("Statische Methoden werden mit dem Klassennamen aufgerufen.", new int[]{ KLASSEN , METHODEN , STATIC}) , 
		   new JavaTipp("Alle Attribute in einem neuen Objekt werden im Konstruktor initialisiert.", new int[]{ KLASSEN , KONSTRUKTOREN , ATTRIBUTE}) , 
		   new JavaTipp("Beim Überschreiben darf die Sichtbarkeit nicht verschärft werden.",new int[]{KLASSEN , METHODEN , UBERSCHREIBEN }) , 
		   new JavaTipp("Alle Elemente in einem Interface sind immer 'public'", new int[]{ INTERFACES , SICHTBARKEITEN , JAVA_8 }) 
		 } ;
		
		for(JavaTipp tipp : arryTipps) {
			System.out.println(tipp);
		}
		System.out.println();
		
		
		System.out.println("\nGenau zwei themen Klassen  : \n");
		Predicate<JavaTipp> zweiThemenPre =  t-> t.getThemen().length == 2;
		ptinIF(arryTipps , zweiThemenPre);
		
		System.out.println("\nFinden Klasse im Text\n");
		Predicate<JavaTipp> klassImtextPred = t -> t.text.contains("Klasse") ;
		ptinIF(arryTipps , klassImtextPred);
		
				
		System.out.println("\nNur thema Klassen  : \n");
		Predicate<JavaTipp> klassePre =  JavaTippPredicate.hasThema(KLASSEN);
		ptinIF(arryTipps , klassePre);

			
		
		System.out.println("\nDas Thema 'Klassen' haben aber dabei kein Thema 'Vererbung'  : \n");
		Predicate<JavaTipp> klassOhneVererbungPre = JavaTippPredicate.selectThema1WithoutThema2(KLASSEN , VERERBUNG);
		ptinIF(arryTipps , klassOhneVererbungPre);
	
		System.out.println("\nAlle Themen außer Klassen\n");
		Predicate<JavaTipp> selectAllbutNotthisOnePredict = JavaTippPredicate.withOutThisThema(KLASSEN);
		ptinIF(arryTipps , selectAllbutNotthisOnePredict);

		
	
		
	}
	

	static void ptinIF( JavaTipp[] tipps , Predicate<JavaTipp> pred) {
		for(JavaTipp tipp : tipps) {
			if(pred.test(tipp))
				System.out.println(tipp);
		}

	}
	


	
	
}

