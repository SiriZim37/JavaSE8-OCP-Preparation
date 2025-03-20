package wdh;

// Pholymorphiesche
class Formatter {
	String title(String title) { return title; }
	String plain(String text) { return text; }
}

class HTMLFormatter extends Formatter{

	@Override
	public String title(String title) {
		return  "<h1>" + title + "</h1>";
	}
	
	@Override
	public String plain(String text) {
		return   "<p>"+ text + "</p>";
	}
}

class MarkFormatter extends Formatter{

	@Override
	public String title(String title) {
		return  "#" + title + "#" ;
	}
	
	@Override
	public String plain(String text) {
		return  text ;
	}
}

public class UniverselleKomponeteEntwickelnNochmal {

	public static void main(String[] args) {
		
		String tiele = "Polymorphie";
		String text = "Polymorphie ist Vielgestaltigkeit";
		
		String simpleText = format(tiele,text, new Formatter() );
		/*
		 *  Polymorphie
		 *  Polymorphie ist Vielgestaltigkeit
		 */
		System.out.println(simpleText);
		
		
		String htmlText = format(tiele,text, new HTMLFormatter() );
		/*
		 *  <h1>Polymorphie</h1>
		 *  <p>Polymorphie ist Vielgestaltigkeit</p>
		 */
		System.out.println(htmlText);
		
		String markdownText = format(tiele,text ,  new MarkFormatter() );
		
		/*
		 *  # Polymorphie #
		 *  Polymorphie ist Vielgestaltigkeit
		 */
		System.out.println(markdownText);

	}

	static String format(String title , String text , Formatter logik) {
		
		String result = logik.title(title);
		result += "\n";
		result += logik.plain(text);
		
		return result;
	}
}
