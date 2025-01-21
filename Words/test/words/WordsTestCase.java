package words;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class WordsTestCase {


	@Test
	void testPasswords() {
		
		List<String> list = Words.passwords();
		assertEquals(10_000, list.size());
		
	}

	@Test
	void testEnglishWords() {
		
		List<String> list = Words.englishWords();
		assertEquals(354_297, list.size());
		
	}
	
	@Test
	void testGermanWords() {
		
		List<String> list = Words.germanWords();
		assertEquals(1_908_815, list.size());
		
	}
	

}
