package ocpexam;

interface ZZ {

}

class XX implements ZZ{
	public String toString(){
		return "X ";
	}
	public static void main(String[] args){
		YY myY = new YY();
		XX myX = myY;
		ZZ myZ = myX;
		System.out.print(myX);
		System.out.print((YY)myX);
		System.out.print(myZ);
	}
}

class YY extends XX{
	public String toString(){
		return "Y ";
	}
}

public class ClassObjectTest {

	/*
	 * Answer : Y Y Y
	 */
	
}
