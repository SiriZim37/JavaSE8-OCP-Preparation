package aufgaben.streams.reduces;

import java.util.Arrays;
import java.util.Optional;

public class TextStatisticsImpl  implements TextStatistics {
	
	private String text;

	public TextStatisticsImpl(String text) {
		this.text = text;
	}

	@Override
	public int getCountChars() {
//		return (int)text.chars().count();
		return text.length();
	}

	@Override
	public int getCountSpecialChars() {
		return (int)text.chars() // IntStream
				.filter( (int x) -> !Character.isLetter(x) )
				.count();
	}

	@Override
	public int getCountLetters() {
		return getCountChars() - getCountSpecialChars();
	}

	@Override
	public Optional<String> getLongestWord() {
		String[] words = text.split(" ");
		
//		Comparator<String> cmp = (s1, s2) -> {
//			int result = s1.length() - s2.length();
//			
//			if(result > 0) {
//				return result;
//			}
//			
//			if(result < 0) {
//				return result;
//			}
//			
//			return s1.compareTo(s2);
//		};
		
		return Arrays.stream(words).max(CMP_STRING_DEFAULT);
	}

}