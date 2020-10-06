package spielumwelt;

public abstract class CanvasKomponente {
    /** Aktuelle x-Koordinate des Elements **/
    public int x_Koordinate;
    /** Aktuelle x-Koordinate des Elements **/
    public int y_Koordinate;

    /**
     * Basis Klasse für alle UI/Canvas-Elemente
     * @param x_Koordinate X-Koordinate an der das Canvas-Element positioniert werden soll
     * @param y_Koordinate Y-Koordinate an der das Canvas-Element positioniert werden soll
     */
    public CanvasKomponente(int x_Koordinate, int y_Koordinate) {
        this.x_Koordinate = x_Koordinate;
        this.y_Koordinate = y_Koordinate;
    }
}
