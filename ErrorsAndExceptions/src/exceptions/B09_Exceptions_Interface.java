package exceptions;

import java.io.IOException;

public class B09_Exceptions_Interface {

	public static void main(String[] args) {
	

	}

}
// Wenn eine Klasse dieses Interface implementiert, muss sie die myMethod()-Methode überschreiben 
// und die deklarierte Ausnahme (IOException) behandeln oder weitergeben:
class MyClass implements MyInterface {
    @Override
    public void myMethod() throws IOException {
        // Methode implementieren, die IOException werfen kann
        throw new IOException("IO Error occurred");
    }
}

interface MyInterface {
    void myMethod() throws IOException;
}