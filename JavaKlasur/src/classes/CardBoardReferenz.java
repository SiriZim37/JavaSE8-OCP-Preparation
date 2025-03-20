package classes;

public class CardBoardReferenz {


	CardBoardReferenz() {}
	CardBoardReferenz(CardBoardReferenz c) {cc1 = c;}
	CardBoardReferenz cc1;
	
	
	public static void main(String[] args) {
		
	
		CardBoardReferenz b1 = new CardBoardReferenz();
		CardBoardReferenz b2 = new CardBoardReferenz(b1);
		CardBoardReferenz b3 = b2.cc1;
		CardBoardReferenz b4 = b1.cc1;
		b3.go();
		b4.go();	// b4 wird Nullpointer exception ( weil b4 ( c11 wird noch nicht in b1 initialisiert.)) 
	

	}

	void go() {
		System.out.println("go");
	}
	
}
