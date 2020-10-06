package spielumwelt.hintergrund;

public class Level extends Zaehler {

    /**
     * Erstellt einen neuen Level zähler
     * @param x_koordinate X-Koordinate, an der der Level-Zaheler angezeigt werden soll
     * @param y_koordinate Y-Koordinate, an der der Level-Zaheler angezeigt werden soll
     */
    Level(int x_koordinate, int y_koordinate) {
        super(x_koordinate, y_koordinate, 1);
    }

    /**
     * Zählt das Level um eins hoch
     */
    public void levelErhoehen() {
            zaehler++;
    }

    /**
     * Gibt das aktuelle Level aus
     * @return String, der das aktuelle Level visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Level: " + zaehler + "\n");
        return stringBuilder.toString();
    }
}
