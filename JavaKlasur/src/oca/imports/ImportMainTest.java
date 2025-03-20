package oca.imports;

import oca.importsA.*;		// ok 
import oca.importsA.ImportClassTestA;	// ok
import static oca.importsA.ImportClassTestA.staticMethodeBTestII; // ok 
//import oca.importsA.ImportClassTestA.methodeBTestII;	// cf


import oca.importsB.*;

public class ImportMainTest extends ImportClassTestA {


	public static void main(String[] args) {
		
		ImportClassTestA a = new ImportClassTestA();
		ImportClassTestB b = new ImportClassTestB();
		
//		a.methodeBTest(); // cf : pakage private 
		
		a.methodeBTestII();
		
		ImportClassTestA.staticMethodeBTestII();
		a.staticMethodeBTestII();
		
		
	}

}
