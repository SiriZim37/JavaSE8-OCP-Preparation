# Aufgabe 'Stream - count/min/max'

> Falls Sie die Klasse `java.util.Locale` nicht kennen, versuchen Sie mithilfe der Javadocs eine grobe Vorstellung davon zu bekommen. 

###### A1.
Gegeben ist ein `java.util.Locale` Array:

	Locale[] locales = Locale.getAvailableLocales();

Bilden Sie eine Stream-Pipeline, die das `Locale` mit dem lexikographisch größten Wert findet, den man aus der Methode `getDisplayCountry` bekommt. 

###### A2.
Gegeben ist ein `java.util.Locale` Array:

	Locale[] locales = Locale.getAvailableLocales();

Bilden Sie eine Stream-Pipeline, die die Anzal der Array-Elementen ermittelt, die als Sprache 'de' haben ("de" mit der Methode `getLanguage` liefern). 

###### A3.
Gegeben ist ein `java.util.Locale` Array:

    Locale[] locales = Locale.getAvailableLocales();

und folgender Code:

	 // A    
    List<Locale> filtered = new ArrayList<>();
    for (Locale locale : locales) {
        if(locale.getDisplayCountry().contains("t")) {
            filtered.add(locale);
        }
    }
    
    Comparator<Locale> cmp = (loc1, loc2) -> 
            loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());
    
    filtered.sort( cmp );
    
    Locale min = null;
    if(filtered.size() > 0) {
        min = filtered.get( 0 );
    }
    // B

Bilden Sie eine Stream-Pipeline, die die Zeilen zwischen A und B ersetzt, also 

	- Das Array 'locales' als Datenquelle verwendet
	- Nur die Elemente berücksichtigt, die in dem Display-Country ein 't' haben (in dem Wert aus der Methode `getDisplayCountry`)
	- Das nach dem Display-Language-Wert kleinste Locale-Element ermittelt und bereitstellt (falls vorhanden). Die Locale-Elemente sollten also lexikographisch nach dem Wert aus `getDisplayLanguage` vergliechen werden.

Geben Sie Display-Country und Display-Language für das so ermittelte Local-Element aus (falls vorhanden).
