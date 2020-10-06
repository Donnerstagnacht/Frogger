package spielumwelt.vordergrund.hindernisse;

import java.awt.*;

public class Auto extends Hindernis implements Cloneable {
    /** Kreiert ein neues Auto
     *
     * @param x_koordinate int
     * @param y_koordinate int
     * @param laenge int, Gibt die Länge des Autos an
     * @param linksfahren boolean, Zeigt an ob das Auto nach links (true) oder rechts (false) fährt
     * @param farbe awt.Color, Gibt die Fabre des Autos an
     * @param geschwindigkeit int, Gibt die Geschwindigkeit des Autos an
     * @param anzahl int, Gibt die Anzahl der AutoClone an
     * @param hitBoxBreite int, Gibt die Breite des Autos an
     * @param setback int, Gibt an wie wie viel das Auto nach hinten versetzt wird
     */
    public Auto(int x_koordinate, int y_koordinate, int geschwindigkeit, int laenge, boolean linksfahren, Color farbe, int anzahl, int hitBoxBreite, int setback) {
        super(x_koordinate, y_koordinate, geschwindigkeit, laenge, linksfahren, farbe, anzahl, hitBoxBreite, setback);
    }

    /** Gibt das Auto aus
     *
     * @return String, der das Auto visualisiert
     */
    @Override
    public String toString() {
        return ausgeben();
    }

    /** Erstellt einen Auto-Klon
     *
     * @return Auto, Gibt einen identischen Auto-Klon zurück
     */
    @Override
    protected Auto clone() {
        return new Auto(x_Koordinate-setback, y_Koordinate, geschwindigkeit, laenge, linksbewegen, farbe, anzahl, hitBoxBreite, setback);
    }

    private String ausgeben() {
        StringBuilder stringBuilder = new StringBuilder();

        if(linksbewegen) {
            stringBuilder.append(" O");
            for(int start = 0; start < laenge-3; start++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("O\n");

            stringBuilder.append("<=");
            for(int start = 0; start < laenge-3; start++) {
                stringBuilder.append("=");
            }
            stringBuilder.append("=\n");

            stringBuilder.append(" O");
            for(int start = 0; start < laenge-3; start++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("O\n");
        } else {
            stringBuilder.append("O");
            for(int start = 0; start < laenge-3; start++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("O \n");

            stringBuilder.append("=");
            for(int start = 0; start < laenge-3; start++) {
                stringBuilder.append("=");
            }
            stringBuilder.append("=>\n");

            stringBuilder.append("O");
            for(int start = 0; start < laenge-3; start++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("O \n");
        }
        return stringBuilder.toString();
    }

}
