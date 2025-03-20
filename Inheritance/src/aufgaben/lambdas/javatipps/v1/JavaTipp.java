package aufgaben.lambdas.javatipps.v1;

public class JavaTipp {
	
	String text ; 
	int[] themen;
	
	public JavaTipp( String text , int[]themen) {
		this.text = text ;
		this.themen = themen;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public int[] getThemen() {
		return themen;
	}

	public void setThemen(int[] themen) {
		this.themen = themen;
	}

	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();

		for (int thema : this.themen) {
			 strBuild.append(Thema.getThemaName(thema)).append(" ");
	    }
		 
		return "Text: " + text + "\nThemen: " + strBuild.toString();
	}
	
	public boolean genau2Thema(int thema) {
		for(int t : this.themen) {
			if(t == thema)
			return true;
		}
		return false;
	}


}
