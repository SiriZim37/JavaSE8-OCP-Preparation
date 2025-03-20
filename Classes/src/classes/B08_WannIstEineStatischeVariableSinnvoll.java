package classes;


/*
 * Singleton-Klasse: nur ein Objekt der Klasse existiert.
 */
class AppSettings{
	
//		public static final AppSettings INSTANCE = new AppSettings(); // #1 mit Statische
	
	private static AppSettings instance;
	
	public static AppSettings getInstance() {
		if(instance==null) {
			instance = new AppSettings();
		}
		
		return instance;
	}
	
	private AppSettings() {}
	
	//...
	
}

public class B08_WannIstEineStatischeVariableSinnvoll {

	/*
	 * s. auch B07, statische Variable count
	 */
	public static void main(String[] args) {

		/*
		 * ein AppSettings-Objekt wird beim ersten Aufruf erzeugt: 
		 */
		AppSettings as = AppSettings.getInstance();
		
		/*
		 * Das AppSettings-Objekt wird wieder gefunden: 
		 */
		AppSettings as2 = AppSettings.getInstance();

	}

}
