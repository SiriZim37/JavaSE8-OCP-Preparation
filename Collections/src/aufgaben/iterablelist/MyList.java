package aufgaben.iterablelist;

import java.util.Iterator;

 class MyIterator implements Iterator<String> {
	private  MyList list;
	
	public MyIterator(MyList list) {
		this.list = list;
	}
	 
    private int nextIndex;

    @Override
    public boolean hasNext() {
        return nextIndex < list.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("Keine weiteren Elemente.");
        }
        return list.get(nextIndex++);
    }
}

public class MyList implements Iterable<String>  {
	
	private String[] elements;
	
	 private int nextFreePos;
	 
	 private static final int maxSize = 10; // symbolische Konstante definieren

	 public MyList() {
	    elements = new String[maxSize]; 
	 }

	 public void add(String element) {
		 if (element == null) {
	          throw new IllegalArgumentException("Element darf nicht null sein."); 
	     }
	     if (nextFreePos >= 10) {
	    	  throw new IllegalStateException("Kein Platz mehr");
	     }
	     elements[nextFreePos] = element;
	     nextFreePos++;
	 }

	 public int size() {
	     return nextFreePos; 
	 }

	 public String get(int index) {
	     if (index < 0 || index >= maxSize) {
	         throw new IndexOutOfBoundsException("Ungültiger Index: " + index);
	     }
	     if (index >= nextFreePos) {
	         throw new IllegalStateException("Die Position " + index + " ist noch nicht belegt.");
	     }
	     return elements[index];
	 }
	    

	// Alternaive 1 new Class
	 /*
	public Iterator<String> iterator() {
		return new MyIterator(this);
	}
	*/
	
	public Iterator<String> iterator() {
		return new MyListIterator();		// eigentlich this.new MyListIterator();
	}
	
	// Alternaive 2 Inner Class  
	private class MyListIterator implements Iterator<String> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex < nextFreePos;
        }

        public String next() {
            if (!hasNext()) {
                throw new IllegalStateException("Keine weiteren Elemente.");
            }
            return elements [nextIndex++];		// MyList.this.get(nextIndex)
        }
    }
   
}
