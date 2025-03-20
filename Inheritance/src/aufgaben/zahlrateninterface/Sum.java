package aufgaben.zahlrateninterface;

public interface Sum {
	 /** 
     * Addiert a.
     */
    void add(int a);

    /** 
     * Addiert a, dann b.
     */
    // A1
    default void add(int a, int b) {
    	add(a);
    	add(b);
    }

    /** 
     * Liefert die Summe zurück
     */
    int getSum();
}
