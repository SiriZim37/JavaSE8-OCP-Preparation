Aufgabe: Design-Korrektur (Design-Prinzipien)
=============================================
Gegeben sind die Klassen Position, Warenkorb und Bestellung. (siehe unten)
Diese Klassen so umstellen, dass die Entwurfsziele bezüglich Kapselung, Kohäsion, Koppelung erreicht werden.

P.S. Der Quellcode ist bereits vorhanden: siehe Paket "Fragestellung"

Wichtige Tips:
- Optimieren Sie die Klasse Bestellung
  Was wird in der Schleife berechnet? Antwort: Nettopreis vom Warenkorb
  Macht das nicht Sinn, diese Schleife in eine Methode
  getNettoPreis() in der Klasse Warenkorb zu verschieben?
- Klasse Warenkorb nach der Änderung:
  positionen[i].artikelPreis * positionen[i].artikelMenge?
  Ist es nicht der Preis einer Position?
  Macht es nicht Sinn, diese Berechnung in eine Methode getNettoPreis() in der Klasse Position zu verschieben?
=============================================
class Position {
  public float artikelPreis;
  public int artikelMenge;
}
=============================================
class Warenkorb {
  public Position[] positionen;
}
=============================================
public class Bestellung {
  private Warenkorb warenkorb;
  private float mwSt;

  public Bestellung(Warenkorb warenkorb, float mwSt) {
    this.warenkorb = warenkorb;
    this.mwSt = mwSt;
  }
 public float getGesamtPreis() {float gesamtPreis = 0;
  for (int i = 0; i < warenkorb.positionen.length; i++) {
   gesamtPreis += warenkorb.positionen[i].artikelPreis *  warenkorb.positionen[i].artikelMenge;
  }
  gesamtPreis += gesamtPreis * mwSt;
  return gesamtPreis;
 }
}
=============================================
