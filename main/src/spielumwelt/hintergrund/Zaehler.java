package spielumwelt.hintergrund;

import spielumwelt.CanvasKomponente;

public class Zaehler extends CanvasKomponente implements Comparable<Zaehler> {
    /** Zähler */
    public int zaehler;

    /**
     * Erstellt ein neues Zähler Element
     * @param x_koordinate X-Koordinate an der das Zähler Element angezeigt werden soll
     * @param y_koordinate Y-Koordinate an der das Zähler Element angezeigt werden soll
     * @param zaehler Startzahl, bei der der Zähler beginnen soll zu zählen
     */
    Zaehler(int x_koordinate, int y_koordinate, int zaehler) {
        super(x_koordinate, y_koordinate);
        this.zaehler = zaehler;
    }

    /**
     * Vergleicht den aktuellen Inhalt des Zählers mit einem anderem Zähler
     * @param compZaehler der zu vergleichende Zähler
     * @return int, die Differenz zwischen diesem Zähler und dem anderem Zähler Element
     */
    @Override
    public int compareTo(Zaehler compZaehler) {
        return zaehler - compZaehler.zaehler;
    }
}
