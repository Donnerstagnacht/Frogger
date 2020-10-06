package spielumwelt.hintergrund;

import spielumwelt.CanvasKomponente;

public class Trenner extends CanvasKomponente  {

    /** Kreiert einen neuen Trenner
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    Trenner(int x_koordinate, int y_koordinate) {
        super(x_koordinate, y_koordinate);
    }

    /** Gibt den Trenner aus
     *
     * @return String, der den Trenner visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------------------------------------------------");
        return stringBuilder.toString();
    }
}
