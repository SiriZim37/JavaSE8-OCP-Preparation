package aufgaben.apis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAPITest {


    @ParameterizedTest
    @CsvSource({
        "'Hello Java!', 'Hello', ' Java!'",
        "'HelloAnna',   'Hello',   'Anna'",
        "'abc123',      'abc'  ,   '123'"
    })
    void testConcat(String expected, String str1, String str2) {
        assertEquals(expected, str1.concat(str2));
        assertEquals(expected, str1 + str2);  
    }
    
	
    @ParameterizedTest
    @CsvSource({
        "'e', 'Hello', 1",
        "'l', 'Hello', 2",
        "'a', 'Anna' , 3"
    })
    void testCharAt(char expected, String input, int index) {
        assertEquals(expected, input.charAt(index));
    }
	
    @ParameterizedTest
    @CsvSource({
        "true, ''",
        "false, 'Hello'",
        "false, ' '"
    })
    void testIsEmpty(boolean expected, String input) {
        assertEquals(expected, input.isEmpty());
    }
	
    @ParameterizedTest
    @CsvSource({
        "'HELLO', 'Hello'",
        "'ANNA', 'annA'",
        "'BOBBY', 'boBBy'"
    })
    void testToUpperCase(String expected, String input) {
        assertEquals(expected, input.toUpperCase());
    }
    
    
    @ParameterizedTest
    @CsvSource({
        "'hello', 'Hello'",
        "'java', 'JAVA'",
        "'bobby', 'boBBy'"
    })
    void testToLowerCase(String expected, String input) {
        assertEquals(expected, input.toLowerCase());
    }
    

    
    @ParameterizedTest
    @CsvSource({
    	"true, 'Hello', 'H'",
        "true, 'Hello', 'He'",
        "false, 'Hello', 'lo'" ,
        
    })
    void testStartsWith(boolean expected, String str, String prefix) {
        assertEquals(expected, str.startsWith(prefix));
    }
    
    @ParameterizedTest
    @CsvSource({
        "true, 'Hello', 'llo', 2",
        "true, 'Hello', 'el', 1",
        "false, 'Hello', 'lo', 1"
    })
    void testStartsWithOffset(boolean expected, String str, String prefix, int toffset) {
        assertEquals(expected, str.startsWith(prefix, toffset));
    }
    
    
    @ParameterizedTest
    @CsvSource({
        "true ,'JaVa', 'JaVa'",
        "false , 'Java', 'java'",
        "true ,'Java', 'Java', "   
    })
    void testEquals(boolean expected , String str1, String str2) {
        assertEquals(expected, str1.equals(str2));
    }
    
    @Test
    void testEqualsReference() {
        assertTrue("JaVa".equals("JaVa"));
        assertFalse("Java".equals("java"));       
        String s1 = new String("Java");
        String s2 = new String("Java");
        assertFalse(s1 == s2); 
        assertTrue(s1.equals(s2)); 
    }

    @ParameterizedTest
    @CsvSource({
        "true, 'hello', 'Hello'",
        "false, 'hello', 'world'",
        "false, 'java', 'python'"
    })
    void testEqualsIgnoreCase(boolean expected, String str1, String str2) {   
        assertEquals(expected, str1.equalsIgnoreCase(str2));
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, 'hello', 'e'",
        "-1, 'hello', 'x'",
        "4, 'hello', 'o'"
    })
    void testIndexOf(int expected, String str, char ch) {
        assertEquals(expected, str.indexOf(ch));
    }
    
  
    
    @ParameterizedTest
    @CsvSource({
        "2, 'Hello, World!', 'l', 1",
        "8, 'Hello, World!', 'o', 5",
        "4, 'Hello, World!', 'o', 2",
        "-1, 'Hello, World!', 'W', 8",
    })
    void testIndexOfFromIndex(int expected, String str, char ch, int fromIndex) {
        assertEquals(expected, str.indexOf(ch, fromIndex));
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, 'hello', 'el'",
        "-1, 'hello', 'world'",
        "0, 'hello', 'he'"
    })
    void testIndexOfString(int expected, String str, String searchStr) {
        assertEquals(expected, str.indexOf(searchStr));
    }
    
    @ParameterizedTest
    @CsvSource({
        "2, 'Hello, World!', 'll', 2",
        "-1, 'Hello, World!', 'Wo', 8",
        "0, 'Hello, World!', 'He', 0"
    })
    void testIndexOfStringFromIndex(int expected, String str, String searchStr, int fromIndex) {
        assertEquals(expected, str.indexOf(searchStr, fromIndex));
    }
    
    
    @ParameterizedTest
    @CsvSource({
        "3, 'hello', 'l'",
        "-1, 'hello', 'x'",
        "4, 'hello', 'o'"
    })
    void testLastIndexOf(int expected, String str, char ch) {
        assertEquals(expected, str.lastIndexOf(ch)); // this.charAt(k) == ch
    }
    
    @ParameterizedTest
    @CsvSource({
        "3, 'hello', 'lo'",
        "-1, 'hello', 'java'",
        "0, 'hello', 'he'"
    })
    void testLastIndexOfString(int expected, String str, String searchStr) {
        assertEquals(expected, str.lastIndexOf(searchStr));
    }
    
    @ParameterizedTest
    @CsvSource({
        "2, 'hello', 'll', 3",
        "0, 'hello', 'he', 2",
        "-1, 'hello', 'java', 2"
    })
    void testLastIndexOfStringFromIndex(int expected, String str, String searchStr, int fromIndex) {
        assertEquals(expected, str.lastIndexOf(searchStr, fromIndex));
    }
    
    @ParameterizedTest
    @CsvSource({
        "Hob, Bob, B, H",
        "hella, hello, o, a",
        "Caddy, Daddy, D, C"
    })
    void testReplaceChar(String expected, String str, char oldChar, char newChar) {
        assertEquals(expected, str.replace(oldChar, newChar));
    }
   
    @ParameterizedTest
    @CsvSource({
        "'Hob', 'Bob', 'B', 'H'",
        "'hello', 'hello', 'z', 'x'",
        "'Caddy', 'Daddy', 'D', 'C'"
    })
    void testReplaceString(String expected, String str, String target, String replacement) {
        assertEquals(expected, str.replace(target, replacement));
    }
    
    @ParameterizedTest
    @CsvSource({
        "'ello', 'hello', 1",
        "'java', 'hellojava', 5",
        "'o', 'hello', 4"
    })
    void testSubstringBeginIndex(String expected, String str, int beginIndex) {
        assertEquals(expected, str.substring(beginIndex));
    }
    
    @ParameterizedTest
    @CsvSource({
        "'ell', 'hello', 1, 4",
        "'java', 'hellojava', 5, 9",
        "'lo', 'hello', 3, 5"
    })
    void testSubstringBeginEndIndex(String expected, String str, int beginIndex, int endIndex) {
        assertEquals(expected, str.substring(beginIndex, endIndex));
    }
    
    @ParameterizedTest
    @CsvSource({
    	  "true, true",
          "false, false"
    })
    void testValueOfBoolean(String expected, boolean value) {
        assertEquals(expected, String.valueOf(value));
    }
    
    @ParameterizedTest
    @CsvSource({
        "'a', 'a'",
        "'b', 'b'"
    })
    void testValueOfChar(String expected, char value) {
        assertEquals(expected, String.valueOf(value));
    }
    

    ////////////---------wrong -> must fix!! --------///////////////
    @ParameterizedTest
    @CsvSource({
        "'hello', h, e, l, l, o",
        "'java', j, a, v, a"
    })
    void testValueOfCharArray(String expected, char...chars) {
    	char[] charArray = new char[chars.length];
    	for (int i = 0; i < charArray.length; i++) {
    		  charArray[i]  = chars[i] ;
        }
    	assertEquals(expected, String.valueOf(charArray));
    }

    ////////////-----------------///////////////
    
    @Test
    void testValueOfCharArraySimple() {
        char[] ch1 = {'H', 'e', 'l', 'l', 'o'};
        String str = String.valueOf(ch1);
        assertEquals("Hello", str);
        
        char[] ch2 = {'J', 'a', 'v', 'a'};
        str = String.valueOf(ch2);
        assertEquals("Java", str);
    }
    
    
    @ParameterizedTest
    @CsvSource({
        "1.0, 1.0",
        "3.14, 3.14",
        "0.0, 0.0"
    })
    void testValueOfDouble(String expected, double value) {
        assertEquals(expected, String.valueOf(value));
    }
    
    @ParameterizedTest
    @CsvSource({
        "1.0, 1.0",
        "3.14, 3.14",
        "0.0, 0.0"
    })
    void testValueOfFloat(String expected, float value) {
        assertEquals(expected, String.valueOf(value));
    }
    

    
    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "42, 42",
        "0, 0"
    })
    void testValueOfInt(String expected, int value) {
        assertEquals(expected, String.valueOf(value));
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "123456789, 123456789",
        "0, 0"
    })
    void testValueOfLong(String expected, long value) {
        assertEquals(expected, String.valueOf(value));
    }

    @ParameterizedTest
    @CsvSource({
        "null, null",
        "'test', test",
        "'123', 123"
    })
    void testValueOfObject(String expected, Object value) {
        assertEquals(expected, String.valueOf(value));
    }
    
    
}
