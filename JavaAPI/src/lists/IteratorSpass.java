package lists;

import java.util.Iterator;

class MyList implements Iterable<String>{

	@Override
	public Iterator<String> iterator() {
		return null;
	}
	
}

public class IteratorSpass {
	
	public static void main(String[] args) {


		MyList list = new MyList();
		
		try {
			
			for (String s : list) {
				
			}
			
		} catch (NullPointerException e) {
			System.out.println("Fehler!");
			System.out.println(e.getMessage());
			// Cannot invoke "java.util.Iterator.hasNext()" because "<local3>" is null
		}
		
		
				

	}

}
