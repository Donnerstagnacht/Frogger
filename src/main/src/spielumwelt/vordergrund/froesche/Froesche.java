package spielumwelt.vordergrund.froesche;

import spiel.Menu;

public class Froesche {
    private int anzahlFroesche;
    /** Array aus Fröschen, die die andere Straßenseite erreicht haben **/
    public final Frosch[] froesche;

    /** Kreiert einen neuen Frosch **/
    public Froesche() {
        anzahlFroesche = 0;
        froesche = new Frosch[10];
    }

    /** Fügt einen neuen Frosch bei Erreichen der anderen Straßenseite dem Frosch[] hinzu
     *
     * @param frosch Frosch, der die andere Straßenseite erreicht hat
     */
    public void froschHinzufuegen(Frosch frosch) {
        Frosch froschCopy = (Frosch) frosch.clone();
        Menu.gameView.playSound("goal.wav", false);
        froesche[anzahlFroesche] = froschCopy;
        anzahlFroesche++;
    }
}
