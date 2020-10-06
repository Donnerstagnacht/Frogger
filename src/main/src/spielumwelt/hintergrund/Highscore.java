package spielumwelt.hintergrund;

public class Highscore extends Zaehler {
    /** Aktuelle Highscore **/
    public int highscore;

    /** Kreiert eine neues Highscore-Element **/
    Highscore(int x_koordinate, int y_koordinate, int highscore) {
        super(x_koordinate, y_koordinate, highscore);
        this.highscore = highscore;
    }

    /** Erhöht die Highscore, wenn Score bei Spielende höher als bisherige
     * Highscore ist
     */
    public int highScoreErhoehen(Zaehler rundenScore) {
        if(compareTo(rundenScore) < 0) {
            highscore = rundenScore.zaehler;
            return highscore;
        }
        return rundenScore.zaehler;
    }

    /** Gibt die Highscore aus
     *
     * @return String, der die Highscore visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Highscore: " + highscore + "\n");
        return stringBuilder.toString();
    }
}
