package aufgaben.zahlrateninterface;

public interface Container {
	  /** 
     * Speichert Element x im Container.
     */
    void add(int x);

    /**
     * Speichert im Container das Element x, danach das Element y.
     */
    // A2
    default void add(int x, int y) {
    	add(x);
    	add(y);
    }

    /**
     * Liefert die Anzahl der Elemente im Container zurück
     */
    int getSize();
}
