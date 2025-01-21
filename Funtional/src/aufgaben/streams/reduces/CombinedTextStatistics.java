package aufgaben.streams.reduces;

import java.util.Optional;

public class CombinedTextStatistics  implements TextStatistics {

	private TextStatistics statA, statB;

	public CombinedTextStatistics(TextStatistics statA, TextStatistics statB) {
		this.statA = statA;
		this.statB = statB;
	}

	@Override
	public int getCountChars() {
		return statA.getCountChars() + statB.getCountChars();
	}

	@Override
	public int getCountSpecialChars() {
		return statA.getCountSpecialChars() + statB.getCountSpecialChars();
	}

	@Override
	public int getCountLetters() {
		return statA.getCountLetters() + statB.getCountLetters();
	}

	@Override
	public Optional<String> getLongestWord() {
		Optional<String> op1 = statA.getLongestWord();
		Optional<String> op2 = statB.getLongestWord();
		
		if(!op1.isPresent()) {
			return op2;
		}
		
		if(!op2.isPresent()) {
			return op1;
		}
		
		String s1 = op1.get(); 		
		String s2 = op2.get(); 		
		
		int result = CMP_STRING_DEFAULT.compare(s1, s2);
		
		if(result>0) {
			return op1;
		}
		
		return op2;
	}
	
}