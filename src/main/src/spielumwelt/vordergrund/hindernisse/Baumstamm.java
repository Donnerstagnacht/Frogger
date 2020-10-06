package spielumwelt.vordergrund.hindernisse;

import java.awt.*;

public class Baumstamm extends Hindernis implements Cloneable {
    /** Kreiert einen neuen Baumstamm
     *
     * @param x_koordinate int
     * @param y_koordinate int
     * @param laenge int, Gibt die Länge des Baumstamms an
     * @param linksfahren boolean, Zeigt an ob sich der Baumstamm nach links (true) oder rechts (false) bewegt
     * @param farbe awt.Color, Gibt die Fabre des Baumstamms an
     * @param geschwindigkeit int, Gibt die Geschwindigkeit des Baumstamms an
     * @param anzahl int, Gibt die Anzahl der BaumstammClone an
     * @param hitBoxBreite int, Gibt die Breite des Baumstamms an
     * @param setback int, Gibt an wie wie viel der Baumstamm nach hinten versetzt wird
     */
    public Baumstamm(
            int x_koordinate, int y_koordinate, int geschwindigkeit, int laenge,
            boolean linksfahren, Color farbe, int anzahl, int hitBoxBreite, int setback)
    {
        super(
                x_koordinate, y_koordinate, geschwindigkeit, laenge,
                linksfahren, farbe, anzahl, hitBoxBreite, setback);
    }

    /** Gibt den Baumstamm aus
     *
     * @return String, der den Baumstamm visualisiert
     */
    @Override
    public String toString() {
        return ausgeben();
    }

    /** Erstellt einen Baumstamm-Klon
     *
     * @return Baumstamm, Gibt einen identischen Baumstamm-Klon zurück
     */
    @Override
    protected Baumstamm clone() {
        return new Baumstamm(x_Koordinate-setback, y_Koordinate, geschwindigkeit, laenge, linksbewegen, farbe, anzahl, hitBoxBreite, setback);
    }

    private String ausgeben() {
        StringBuilder stringBuilder = new StringBuilder();
         for (int breite = 0; breite < hitBoxBreite; breite++) {
                for(int start = 0; start < hitboxLaenge; start++) {
                    stringBuilder.append("=");
                }
                stringBuilder.append("\n");
            }
//        }
        return stringBuilder.toString();
    }

}
