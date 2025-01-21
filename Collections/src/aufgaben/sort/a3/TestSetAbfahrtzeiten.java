package aufgaben.sort.a3;

import java.time.LocalTime;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TestSetAbfahrtzeiten {

	public static void main(String[] args) {
		NavigableSet<String> abfahrtzeiten =  getAbfahrtzeiten();

		
		System.out.println("1. suchen Sie die erste Abfahrtzeit nach 12:03"); 	
		String x = abfahrtzeiten.higher("12:03");		// 12:12
		System.out.println("Ausgabe : " + x );
		
	
		System.out.println("2. suchen Sie nach der ersten Abfahrtzeit vor 12:03"); 	
		x = abfahrtzeiten.lower("12:03");				
		System.out.println("Ausgabe : " + x );	 	// 11:52
		
		
		System.out.println("3. suchen Sie nach der ersten Abfahrtzeit nach 17:12 inklusive"); 	
		x = abfahrtzeiten.ceiling("17:12");		
		System.out.println("Ausgabe : " + x );		// 17:12
		
	
		System.out.println("4. suchen Sie nach der ersten Abfahrtzeit nach 17:12 exklusive"); 	
		x = abfahrtzeiten.higher("17:12");		
		System.out.println("Ausgabe : " + x );		// 17:32
		
		System.out.println("5. suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00" ); 
		NavigableSet<String> subSet = abfahrtzeiten.subSet("12:00" ,false , "13:00" , false); 
		System.out.println("Ausgabe : " + subSet ); // [12:12, 12:32, 12:52]
		
		
		System.out.println("6. suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive"); 
		subSet = abfahrtzeiten.subSet("11:52" ,false , "13:12" , true); 		
		System.out.println("Ausgabe : " + subSet );	 // [12:12, 12:32, 12:52, 13:12]
		
		
		System.out.println("7. suchen Sie nach der erstmöglichen Abfahrtzeit" ); 
		x = abfahrtzeiten.first();		
		System.out.println("Ausgabe : " + x );		//  06:12
		
		
	
		System.out.println("8. suchen Sie nach der letztmöglichen Abfahrtzeit"); 
		x = abfahrtzeiten.last();			
		System.out.println("Ausgabe : " + x );		//  23:52
		
		
		
		System.out.println("\n***************************************************");
		
		NavigableSet<LocalTime> abfahrtLT =  getAbfahrtzeitenLocalTime();
		
		
		System.out.println("1. suchen Sie die erste Abfahrtzeit nach 12:03"); 	
		LocalTime zeit = abfahrtLT.higher(LocalTime.of(12, 3));		// 12:12
		System.out.println("Ausgabe : " + zeit );
		
	
		System.out.println("2. suchen Sie nach der ersten Abfahrtzeit vor 12:03"); 	
		zeit = abfahrtLT.lower(LocalTime.of(12, 3));				
		System.out.println("Ausgabe : " + zeit );	 	// 11:52
		
		
		System.out.println("3. suchen Sie nach der ersten Abfahrtzeit nach 17:12 inklusive"); 	
		zeit = abfahrtLT.ceiling(LocalTime.of(17, 12));		
		System.out.println("Ausgabe : " +zeit );		// 17:12
		
	
		System.out.println("4. suchen Sie nach der ersten Abfahrtzeit nach 17:12 exklusive"); 	
		zeit = abfahrtLT.higher(LocalTime.of(17, 12));		
		System.out.println("Ausgabe : " + zeit );		// 17:32
		
		System.out.println("5. suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00" ); 
		NavigableSet<LocalTime> subSetzeit = abfahrtLT.subSet(LocalTime.of(12, 0) ,false , LocalTime.of(13, 0), false); 
		System.out.println("Ausgabe : " + subSetzeit ); // [12:12, 12:32, 12:52]
		
		
		System.out.println("6. suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive"); 
		subSetzeit = abfahrtLT.subSet(LocalTime.of(11, 52) ,false , LocalTime.of(13, 12) , true); 		
		System.out.println("Ausgabe : " + subSetzeit );	 // [12:12, 12:32, 12:52, 13:12]
		
		
		System.out.println("7. suchen Sie nach der erstmöglichen Abfahrtzeit" ); 
		zeit = abfahrtLT.first();		
		System.out.println("Ausgabe : " + zeit );		//  06:12
		

		System.out.println("8. suchen Sie nach der letztmöglichen Abfahrtzeit"); 
		zeit = abfahrtLT.last();			
		System.out.println("Ausgabe : " + x );		//  23:52
		
		
	}

	static NavigableSet<String> getAbfahrtzeiten(){
		NavigableSet<String> set = new TreeSet<String>();		
		
		for (int stunde  = 6 ; stunde   < 24 ; stunde  ++) {
			for(int minute  = 12 ; minute  < 60 ; minute  = minute +20) {
				set.add(String.format("%02d:%02d", stunde , minute ));
			}
		}
//		for (String s : set) {
//		System.out.println(s);
//	}		
		return set;
	}
	
	// Alternativen 2 
	static TreeSet<LocalTime> getAbfahrtzeitenLocalTime(){
		
		TreeSet<LocalTime> set =  new TreeSet<LocalTime>();		
		
		for (int stunde  = 6 ; stunde   < 24 ; stunde  ++) {
			for(int minute  = 12 ; minute  < 60 ; minute  = minute +20) {
				set.add(LocalTime.of(stunde, minute));
			}
		}
//		for (LocalTime s : set) {
//			System.out.println(s);
//		}
	
		return set;
	
	}
	

	
}
