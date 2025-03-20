package aufgaben.lambdas.javatipps.v1;

interface Thema {

    public static final int VERERBUNG = 0;
    public static final int KLASSEN = 1;
    public static final int INTERFACES = 2;
    public static final int METHODEN = 3;
    public static final int STATIC = 4;
    public static final int KONSTRUKTOREN = 5;
    public static final int ATTRIBUTE = 6;
    public static final int UBERSCHREIBEN = 7;
    public static final int SICHTBARKEITEN = 8;
    public static final int JAVA_8 = 9;
    
     static String getThemaName(int thema) {
    	  switch (thema) {
          case VERERBUNG: return "Vererbung";
          case KLASSEN: return "Klassen";
          case INTERFACES: return "Interfaces";
          case METHODEN: return "Methoden";
          case STATIC: return "static";
          case KONSTRUKTOREN: return "Konstruktoren";
          case ATTRIBUTE: return "Attribute";
          case UBERSCHREIBEN: return "Überschreiben";
          case SICHTBARKEITEN: return "Sichtbarkeiten";
          case JAVA_8: return "Java 8";
          default: return "Unbekannt";
      }
    }
	
}
