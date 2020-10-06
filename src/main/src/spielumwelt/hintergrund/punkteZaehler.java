package spielumwelt.hintergrund;

import spielumwelt.vordergrund.froesche.Frosch;

public class punkteZaehler extends Zaehler {
    private int alteKoordinateX;
    private final int bonusParameter;
    private final Frosch spielerFrosch;

    /** Kreiert eine neue Score-Anzeige
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    punkteZaehler(int x_koordinate, int y_koordinate, int score, Frosch spielerFrosch) {
        super(x_koordinate, y_koordinate, score);
        this.spielerFrosch = spielerFrosch;
        alteKoordinateX = 34;
        bonusParameter = 34;
    }

    /** Erhöht die aktuelle Score **/
    public void scoreErhoehen() {
        if (spielerFrosch.y_Koordinate < alteKoordinateX) {
            zaehler = zaehler + (bonusParameter - spielerFrosch.y_Koordinate) * 10;
            alteKoordinateX = spielerFrosch.y_Koordinate;
            if (alteKoordinateX == 2) {
                alteKoordinateX = 34;
            }
        }
    }

    /** Gibt die aktuelle Score aus
     *
     * @return String, der den aktuellen Score visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Score: " + zaehler + "\n");
        return stringBuilder.toString();
    }
}
