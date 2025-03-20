package classes;

public class WdhTest extends Hobbit {

	public static void main(String[] args) {

		int myGold = 7 ;
//		System.out.println(countGold(myGold)); // 1 : Cannot make a static reference to the non-static method countGold(int) from the type Hobbit
	
	
	}

}


class Hobbit {
	
//	static int countGold(int x) { // es wird funktioniert 
//		return x + 10;
//	}
	
	int countGold(int x) { // 1 : Cannot make a static reference to the non-static method countGold(int) from the type Hobbit
		return x + 10;
	}
}