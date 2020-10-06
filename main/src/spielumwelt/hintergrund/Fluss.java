package spielumwelt.hintergrund;

import spielumwelt.CanvasKomponente;

public class Fluss extends CanvasKomponente {
    private final int flussBreite;
    /** Kreiert einen Fluss
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    Fluss(int x_koordinate, int y_koordinate, int flussBreite) {
        super(x_koordinate, y_koordinate);
        this.flussBreite = flussBreite;
    }

    /** Gibt den Fluss aus
     *
     * @return String, der den Fluss visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int breite = 1; breite < flussBreite; breite++) {
            stringBuilder.append("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB\n");
        }
        return stringBuilder.toString();
    }

}
