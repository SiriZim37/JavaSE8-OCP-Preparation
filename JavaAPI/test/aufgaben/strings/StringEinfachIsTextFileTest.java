package aufgaben.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringEinfachIsTextFileTest {

	
	   @Test
	   void testIsTextFile_einfacherTest(){
		 
		   boolean expected = false;
		   boolean actual = StringEinfachIsTextFile.isTextFile("myfile.jpg");
		   assertEquals(expected, actual);
		   
	   }
	   
	   @Test
	   void testIsTextFile_mehrereDateinInEinemTestCase(){
		   String filename;
		   filename = "myfile.jpg";
		   boolean expected = false;
		   boolean actual = StringEinfachIsTextFile.isTextFile("myfile.jpg");
		   assertEquals(expected, actual , "file :" + filename);
		   
		   filename = "myfile.txt";
		   actual = StringEinfachIsTextFile.isTextFile("myfile.txt");
		   assertEquals(true, actual, "file :" + filename);
	   }
	   
	   @ParameterizedTest
	   @CsvSource(
			   { 
					"myfile.jpg, false",
					"myfile, false",
					".txt, false",
					"txt, false",
					"txt., false",
					
					"file.txt.html, false",
					"hallowelt, false",
					
					"a.txt, true",
					"myfile.txt, true",
					"myfile.Txt, true",
					"myfile.TxT, true",
					"myfile.TXT, true",
				}	   
		)
	   void testIsTxtFile( String filename , boolean expected) {
		   boolean actual = StringEinfachIsTextFile.isTextFile(filename);
		   assertEquals(expected, actual);
	   }
	   
	   @Test
	   void testIsTextFileThorwsExceptionForNUllFileName() {
//		   try {
//			   StringEinfachIsTextFile.isTextFile(null);
//			   fail();
//		   }catch (IllegalArgumentException e) {
//			// test ok
//			}
		   
		   assertThrows(IllegalArgumentException.class, null);
	   }
	   
	
	   @Test
	    public void testIsTextFile_withTxtExtension() {
	        assertTrue(StringEinfachIsTextFile.isTextFile("document.txt"));
	        assertTrue(StringEinfachIsTextFile.isTextFile("script.TxT"));
	        assertTrue(StringEinfachIsTextFile.isTextFile("example.TXT"));
	    }

	    @Test
	    public void testIsTextFile_withOtherExtensions() {
	        assertFalse(StringEinfachIsTextFile.isTextFile("aaa.png"));
	        assertFalse(StringEinfachIsTextFile.isTextFile("document.pdf"));
	    }

	    @Test
	    public void testIsTextFile_withInvalidNames() {
	        assertFalse(StringEinfachIsTextFile.isTextFile(null));  // null input
	        assertFalse(StringEinfachIsTextFile.isTextFile("document"));  // no extension
	        assertFalse(StringEinfachIsTextFile.isTextFile(""));  // empty string
	    }

}
