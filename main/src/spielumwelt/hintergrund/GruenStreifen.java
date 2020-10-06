package spielumwelt.hintergrund;

import spielumwelt.CanvasKomponente;

public class GruenStreifen extends CanvasKomponente {

    /** Kreiert einen Grünstreifen der Straße
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    GruenStreifen(int x_koordinate, int y_koordinate) {
        super(x_koordinate, y_koordinate);
    }

    /** Gibt den Grünstreifen aus
     *
     * @return String, der den Grünstreifen visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG\n");
        stringBuilder.append("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG\n");
        stringBuilder.append("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG\n");
        return stringBuilder.toString();
    }
}
