package aufgaben.stringbuilderapi;

import java.util.List;

public class StringBuilderAPI {


	public static void main(String[] args) {

		
		// A1. 
		test_Constructors();

		// A2 
		test_append();
		test_delete();
		test_deleteCharAt();
		test_insert();
		test_replace();
		test_reverse();
		
		test_toString();	
		
		// A3
		test_charAt();
		test_length();
		
		test_indexOf();
		test_indexOf_fromIndex();
		test_lastIndexOf();
		test_lastIndexOf_fromIndex();
		
		test_substring();
		test_substring_from_start_to_end();
		
		// A4
		test_void_setCharAt();
		test_void_setLength();
		
		// A5 StringBuilder VS StringBuffer 
		/* 	
		 * - Gemeinsame API 
		 * 
		 * StringBuffer : 
		 * 		 - ist langsamer als StringBuilder
		 * 	 	 - ist thread-sicher und synchronisiert (Multi-Threaded)
		 * 
		 * StringBuilder
		 * 		- ist schneller als StringBuffer
		 * 		- ist nicht synchronisiert und daher nicht thread-sicher (Single-Threaded)
		 */
		test_performance();
		test_Multithreding();

	}
	static void test_Multithreding() {
		System.out.println("\n***Multithreding Test:");
		
		StringBuffer stringBuffer = new StringBuffer("Start");
	 	Thread thread1 = new Thread(() -> appendToStringBuffer(stringBuffer));
	    Thread thread2 = new Thread(() -> appendToStringBuffer(stringBuffer));

	    thread1.start();
	    thread2.start();
	        
	    try {
	         thread1.join();
	         thread2.join();
	    } catch (InterruptedException e) {
	          e.printStackTrace();
	   }

	    System.out.println("StringBuffer Ergebnis: " + stringBuffer);


	    StringBuilder stringBuilder = new StringBuilder("Start");
	    Thread thread3 = new Thread(() -> appendToStringBuilder(stringBuilder));
	    Thread thread4 = new Thread(() -> appendToStringBuilder(stringBuilder));

	    thread3.start();
	    thread4.start();

	     try {
	         thread3.join();
	         thread4.join();
	     } catch (InterruptedException e) {
	          e.printStackTrace();
	     }

	     System.out.println("StringBuilder Ergebnis: " + stringBuilder);
	}
	
    private static void appendToStringBuffer(StringBuffer sb) {
        for (int i = 0; i < 500; i++) {
            sb.append("X");
        }
    }
    
    private static void appendToStringBuilder(StringBuilder sb) {
        for (int i = 0; i < 500; i++) {
            sb.append("X");
        }
    }
    
    
	static void test_performance() {
		 System.out.println("\n*** Performance Test:");
		 for (int i = 0; i < 10; i++) {
			  System.out.println(i+1 +".");
	          test_performance_StringBuilder();
	          test_performance_StringBuffer();
	     }
	}
	
	 static void test_performance_StringBuilder() {
	        int iterations = 100_000;
	        
	        long start = System.currentTimeMillis();
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < iterations; i++) {
	        	sb.append("No").append(i);
	        }
	        long end = System.currentTimeMillis();
	        System.out.println("StringBuilder Zeit : " + (end - start) + " ms");
	    }
	    
	 static void test_performance_StringBuffer() {
	        int iterations = 100_000;
	        
	        long start = System.currentTimeMillis();
	        
	        StringBuffer sbf = new StringBuffer();
	        for (int i = 0; i < iterations; i++) {
	        	sbf.append("No").append(i);
	        }
	        long end = System.currentTimeMillis();
	        System.out.println("StringBuffer Zeit : " + (end - start) + " ms");
	 }
	    
	

	static void test_void_setLength() {		
		System.out.println("\n*** void setLength");
		StringBuilder sb = new StringBuilder("Hello, Java!");
		sb.setLength(20);
		System.out.println("Length: " +  sb.length()); 	// 20
		sb.append("Toll");
		System.out.println("After setLength(int n) : " +  sb ); //  Hello, Java!        Toll
		System.out.println("Length: " +  sb.length()); 	// 24
		String str = "HAHA";
		
		for (int i = 0 ; i < sb.length() ; i++) {
			System.out.print(" " +  sb.charAt(i));
		}
		System.out.println();
		for (int i = 0 ; i < str.length() ; i++) {
			System.out.print(" " +  str.charAt(i));
			
		}
		
	}
	
	static void test_void_setCharAt() {	
		System.out.println("\n*** void charAt");
		
		StringBuilder sb = new StringBuilder("Hello, Java!");
		sb.setCharAt(7, 'X');
		System.out.println("Character at index 7: " + sb); // Hello, Xava!
		sb.delete(0, 5);
		System.out.println("Delete 1-100: " + sb); // Hello, Xava!
		
	}
	
	static void test_substring_from_start_to_end() {		
		System.out.println("\n*** substring from start to end");
		
		StringBuilder sb = new StringBuilder("C# and Java! ist toll!");
		System.out.println("Substring from index 7 to 12: " + sb.substring(7,12)); 	// Java!
		
	}
	
	static void test_substring() {		
		System.out.println("\n*** substring");
		
		StringBuilder sb = new StringBuilder("Hello, Java!");
		System.out.println("Substring from index 7: " + sb.substring(7)); 	//Java!
		System.out.println("Substring from index 7 to 8 : " + sb.substring(7,8)); 	//J
		
		String s = new String("54321");
		s = s.substring(1,4);
		System.out.println("Substring from index 4: " + s);
//		s = s.substring(1,4);
//		System.out.println("charAt  index 2: " + s.charAt(2)); // StringIndexOutOfBoundsException
	}
	
	static void test_lastIndexOf_fromIndex() {		
		System.out.println("\n*** lastIndexOf fromIndex");
		
		StringBuilder sb = new StringBuilder("I\'m Anna , He is Bob , She is Lena");
		System.out.println("Last index of 'is' from index 15: " + sb.lastIndexOf("is", 15));	//14
		System.out.println("Last index of 'is' from index 5: " + sb.lastIndexOf("is", 5));  	// -1
		System.out.println("Last index of 'is' from index 30: " + sb.lastIndexOf("is", 30));	//27
	}
	
	
	static void test_lastIndexOf() {		
		System.out.println("\n*** lastIndexOf ");
		
		StringBuilder sb = new StringBuilder("Hello, Java!");
		System.out.println("Last index of 'o': " + sb.lastIndexOf("o")); 	// 4
		System.out.println("Last index of '!': " + sb.lastIndexOf("!")); 	//11
	}
	
	static void test_indexOf_fromIndex() {		
		System.out.println("\n*** indexOf fromIndex");
		
		StringBuilder sb = new StringBuilder("I\'m Anna , He is Bob , She is Lena");
		
		System.out.println("Index of 'Anna' from index 4: " + sb.indexOf("Anna", 4)); // 4
		System.out.println("Index of 'is' from index 5: " + sb.indexOf("is", 5)); 		// 14
		System.out.println("Index of 'is' from index 30: " + sb.indexOf("is", 30)); 	// -1
		System.out.println("Index of 'is' from index 20: " + sb.indexOf("is", 20)); 	// 27
	}

	static void test_indexOf() {		
		System.out.println("\n*** indexOf");
		
		StringBuilder sb = new StringBuilder("Hello, Java!");
		System.out.println("Index of 'Java': " + sb.indexOf("Java")); // 7
	}
	
	static void test_length() {		
		System.out.println("\n*** length");
		
		StringBuilder sb = new StringBuilder("Hello, Java!");
		System.out.println("Length: " + sb.length());	 // 12
		 
	}
	
	static void test_charAt() {		
		System.out.println("\n*** charAt");
		
		StringBuilder sb = new StringBuilder("Hello, Java!");
		System.out.println("Character at index 7: " + sb.charAt(7)); // J
	}
	
	static void test_toString() {	
		System.out.println("\n*** toString");
		
		StringBuilder sb = new StringBuilder("Hello");
		String result = sb.toString(); //  // Convert StringBuilder to String
	    System.out.println("After toString: " + result);	// Hello
	    
	    sb.append(" Java")
	    .append("!.");
	    System.out.println("Modified StringBuilder content: " + sb);	// Hello Java!.
	    System.out.println("String result:  " + result);   	//Hello
	    												 // Change StringBuilder after calling  toString() ,
	    												 // dont affect the previosly String     
	}
	
	static void test_reverse() {	
		System.out.println("\n*** reverse");
		
		StringBuilder sb = new StringBuilder("Java Ist eine Insel.");
		sb.reverse();
		System.out.println("After reverse: " + sb);	 // .lesnI enie tsI avaJ
		

	}
	
	static void test_replace() {	
		System.out.println("\n*** replace");
		
		StringBuilder sb = new StringBuilder("Hello C#");
		sb.replace(6, 8, "Java");
		System.out.println("After replace: "+ sb);	// Hello Java
		
	}
	
	static void test_insert() {	
		
		System.out.println("\n*** insert");

		StringBuilder sb = new StringBuilder("Hello Java");
		sb.insert(5 , ", I\'m")
		  .insert(15, '.') ;
		System.out.println("insert(int offset, char c) : " + sb); // Hello, I'm Java.
		
		StringBuilder sb2 = new StringBuilder(" Java ist eine Insel.");
		sb.insert(15, sb2);
		System.out.println("After insert(int offset, CharSequence c) :" + sb); // Java ist eine Insel.
		
		StringBuilder sb3 = new StringBuilder("Test Hello");
		sb3.insert(3, new Object());
		System.out.println("After insert(int offset, Object obj) : " + sb3); // Tesjava.lang.Object@5b1d2887t Hello
		
		 StringBuilder sb4 = new StringBuilder("The answer is ");
		 sb4.insert(14, true);
		 sb4.insert(18, false);
		 System.out.println("After insert(int offset, boolean b) : " + sb4);	// The answer is truefalse
	
	}
	
	
	static void test_deleteCharAt() {	
		System.out.println("\n*** deleteCharAt");
		
		StringBuilder sb = new StringBuilder("Hello! Java");
		sb.deleteCharAt(5);
		System.out.println("After deleteCharAt: " + sb); // Hello Java
		try {
			sb.deleteCharAt(11);  
			System.out.println(sb);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage());
		}		

	}
	
	static void test_delete() {
		System.out.println("\n*** delete");
		
		StringBuilder sb = new StringBuilder("Hello, Java ist Toll!");
		sb.delete(0, 7);
		System.out.println("After delete: " + sb);	// Java ist Toll!
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("red123");
		sb2.deleteCharAt(0); // ed123
		sb2.delete(1, 2);
		System.out.println("After delete: " + sb2);
	}
	
	static void test_append() {
		System.out.println("\n*** append");
		
		StringBuilder sb = new StringBuilder("Hello")
				.append(" Java")
				.append(" ist ")
				.append("Toll!");
		System.out.println("After append : " + sb);	// Hello Java ist Toll!
		
		StringBuilder sb2 = new StringBuilder("Java")
				.append("C++ ist Toll!" , 3 , 13 );			
		System.out.println("After append \"C++ ist Toll!\" from at index 3 to at index 13 : " + sb2); // Java ist Toll!
		
	}
	
	static void test_Constructors() {
		System.out.println("*** Konstruktoren");
		
		StringBuilder sb1 = new StringBuilder(); 	
		
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb);
		
		StringBuilder sb2 = new StringBuilder(5); // Initiale Kapazität
		sb2.append("Java");
		System.out.println("1." + sb);
		System.out.println("StringBuilder(5) : " +  sb2.capacity()); // 5 
		
		sb2.append(" ist ").append("eine Insel");
		System.out.println("2. "+ sb); // StringBuilder automatically resizes its internal buffer.
		System.out.println("StringBuilder resizes : " +  sb2.capacity()); // 26 (Neue Kapazität)	
		
	}


	
	
}
