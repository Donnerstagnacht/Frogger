package spiel;

import spielumwelt.CanvasKomponente;

public class NachrichtElement extends CanvasKomponente {
    /** Nachricht des Elements */
    public String nachricht;
    /** true, wenn Element gezeigt werden solll, false wenn es versteckt werden soll*/
    public boolean zeigenOderVerstecken;

    /**
     * Erstellt ein neues Nachrichten-Element, dass angezeigt oder versteckt werden kann
     * @param x_koordinate x-Koordinate an der die Nachricht angezeigt werden soll
     * @param y_koordinate y-Koordinate an der die Nachricht angezeigt werden soll
     * @param zeigenOderVerstecken, true, wenn es angezeigt werden soll, false wenn es versteckt werden soll
     */
    public NachrichtElement(int x_koordinate, int y_koordinate, boolean zeigenOderVerstecken) {
        super(x_koordinate, y_koordinate);
        this.zeigenOderVerstecken = zeigenOderVerstecken;
    }
}
