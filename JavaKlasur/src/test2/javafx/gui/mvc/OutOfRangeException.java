package test2.javafx.gui.mvc;

public class OutOfRangeException extends RuntimeException {
	
	String message ;
	
	public OutOfRangeException(String msg) {
		message = msg;
	}

	public String getMessage() {
		return message;
	}
}
