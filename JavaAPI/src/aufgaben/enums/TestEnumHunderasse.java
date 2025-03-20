package aufgaben.enums;

public class TestEnumHunderasse {

	public static void main(String[] args) {
		
		Hunderasse h1 = Hunderasse.DACKEL;
		Hunderasse h2 = Hunderasse.COLLIE;
		Hunderasse h3 = Hunderasse.DOGGE;
		System.out.println(h1 );
		System.out.println(h2 );
		System.out.println(h3 );
		
		Hunderasse[] hunderasse = Hunderasse.values();
		
		for(Hunderasse s : hunderasse) {
			System.out.println(s);
		}

	}

}
