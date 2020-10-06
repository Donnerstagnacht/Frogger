package spielumwelt.hintergrund;

import spielumwelt.CanvasKomponente;

public class StrassenBelag extends CanvasKomponente  {
    private final int strassenBreite;
    /** Kreiert einen Strassenbelag
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    StrassenBelag(int x_koordinate, int y_koordinate, int flussBreite) {
        super(x_koordinate, y_koordinate);
        this.strassenBreite = flussBreite;
    }

    /** Gibt den Strassenbelag aus
     *
     * @return String, der den Strassenbelag visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int breite = 1; breite < strassenBreite; breite++) {
            stringBuilder.append("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n");
        }
        return stringBuilder.toString();
    }
}
