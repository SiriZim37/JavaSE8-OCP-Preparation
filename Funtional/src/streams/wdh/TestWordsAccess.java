package streams.wdh;

import java.util.List;

import words.Words;

public class TestWordsAccess {

	public static void main(String[] args) {

		List<String> passwords = Words.passwords();
		long count = passwords.stream().count();
		System.out.println(count);
	}

}
