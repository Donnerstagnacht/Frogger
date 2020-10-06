package spielumwelt.hintergrund;

public class Zeit extends Zaehler {
    private int zeit;
    private int sekunde;

    /** Kreiert eine neue Uhr/Zeit
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    Zeit(int x_koordinate, int y_koordinate, int zeit) {
        super(x_koordinate, y_koordinate, zeit);
        sekunde = 1000;
    }

    /** Zählt die Zeit um eine Sekunde hoch
     *
     * @param level int, repräsentiert wie oft die Funktion pro Sekunde aufgerufen wird
     */
    public void zaehlen(int level) {
        sekunde = sekunde - level;
        if(sekunde <= 0) {
            zeit++;
            sekunde = 1000;
        }
    }

    /** Gibt die Uhr/Zeit aus
     *
     * @return String, der die Uhr/Zeit visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Time:" + zeit + "\n");
        return stringBuilder.toString();
    }

}
