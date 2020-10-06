package spielumwelt.vordergrund;

import spielumwelt.CanvasKomponente;

public abstract class CanvasBewegungsSteuerung extends CanvasKomponente {
    /** Geschwindigkeit des Canvas-Elements*/
    public int geschwindigkeit;

    /**
     * Erstellt ein neues bewegbares Canvas-Element
     * @param x_koordinate X-Koordinate an der das Canvas-Element angezeigt werden soll
     * @param y_koordinate Y-Koordinate an der das Canvas-Element angezeigt werden soll
     * @param geschwindigkeit geschwindigkeit mit der sich das Canvas-Element bewegen soll
     */
    public CanvasBewegungsSteuerung(int x_koordinate, int y_koordinate, int geschwindigkeit) {
        super(x_koordinate, y_koordinate);
        this.geschwindigkeit = geschwindigkeit;
    }

    /** Objekt nach oben bewegen **/
    public void obenBewegen() {
        y_Koordinate = y_Koordinate - geschwindigkeit;
    }

    /** Objekt nach rechts bewegen **/
    public void rechtsBewegen() {
        x_Koordinate = x_Koordinate + geschwindigkeit;
    }

    /** Objekt nach unten bewegen **/
    public void untenBewegen() { y_Koordinate = y_Koordinate + geschwindigkeit;
    }

    /** Objekt nach links bewegen **/
    public void linksBewegen() {
        x_Koordinate = x_Koordinate - geschwindigkeit;
    }
}
