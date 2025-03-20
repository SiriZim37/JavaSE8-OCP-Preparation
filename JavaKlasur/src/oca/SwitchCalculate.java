package oca;



public class SwitchCalculate {

	public static void main(String[] args) {

		String[] str = new String[] { "aa" , "bb" , "cc" , "dd" , "ee"}; 		
		int count = 0; 
		for (String s : str) {
			
				switch (s) {
				case "ee": count += 1;
				case "bb": count = count - 2;
					break;
				case "cc": count = count + 1;
					break;
				case "dd": count = count + 3;
				case "aa": count = count - 1;
					break;
				}
		}
		System.out.println(count); 	// Aufgabe : -1 

	
	}

}
