package spielumwelt.vordergrund.froesche;

import spielumwelt.vordergrund.CanvasBewegungsSteuerung;
import spielumwelt.vordergrund.hindernisse.Kollidierbar;

public class Frosch extends CanvasBewegungsSteuerung implements Cloneable, Kollidierbar<Frosch> {
    /** Hitboxlänge des Frosches **/
    public final int hitBoxLaenge;
    /** Hitboxbreite des Frosches **/
    public final int hitBoxBreite;

    /** Kreiert einen neuen Frosch
     *
     * @param x_koordinate int
     * @param y_koordinate int
     */
    public Frosch(int x_koordinate, int y_koordinate, int geschwindigkeit) {
        super(x_koordinate, y_koordinate, geschwindigkeit);
        hitBoxBreite = 3;
        hitBoxLaenge = 4;
    }

    /** Gibt den Frosch aus
     *
     * @return String, der den Frosch visualisiert
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" OO \n");
        stringBuilder.append("====\n");
        stringBuilder.append("I  I \n");
        return  stringBuilder.toString();
    }

    /** Erstellt einen Frosch-Klon
     *
     * @return Frosch, Gibt einen identischen Frosch-Klon zurück
     */
    @Override
    protected Object clone() {
        return new Frosch(x_Koordinate, y_Koordinate, geschwindigkeit);
    }

    @Override
    public boolean kollidieren(Frosch spielerFrosch) {
        for (int laengeSpielerFrosch = 0; laengeSpielerFrosch < spielerFrosch.hitBoxLaenge; laengeSpielerFrosch++) {
            for (int laengeFrosch = 0; laengeFrosch < hitBoxLaenge; laengeFrosch++) {
                for (int breiteSpielerFrosch = 0; breiteSpielerFrosch < spielerFrosch.hitBoxBreite; breiteSpielerFrosch++) {
                    for (int breiteFrosch = 0; breiteFrosch < hitBoxBreite; breiteFrosch++) {
                        if(spielerFrosch.x_Koordinate + laengeSpielerFrosch == x_Koordinate + laengeFrosch && spielerFrosch.y_Koordinate + breiteSpielerFrosch == y_Koordinate + breiteFrosch) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
