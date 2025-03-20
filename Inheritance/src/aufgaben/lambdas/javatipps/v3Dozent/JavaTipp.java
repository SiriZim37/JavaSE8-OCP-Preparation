package aufgaben.lambdas.javatipps.v3Dozent;

// A1
public class JavaTipp {
	
	private String text;
	private String themen;
	
	public JavaTipp(String text, String themen) {
		this.text = text;
		this.themen = themen;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getThemen() {
		return themen;
	}

	public void setThemen(String themen) {
		this.themen = themen;
	}

	@Override
	public String toString() {
		return "JavaTipp [text=" + text + ", themen=" + themen + "]";
	}

}
