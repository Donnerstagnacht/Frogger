package spielumwelt.vordergrund.hindernisse;

import spiel.Menu;
import spielumwelt.vordergrund.CanvasBewegungsSteuerung;
import spielumwelt.vordergrund.froesche.Frosch;

import java.awt.*;

public class Hindernis extends CanvasBewegungsSteuerung implements Kollidierbar<Frosch>, Cloneable {
    /** Zeigt an, ob sich das Hindernis nach links (true) oder rechts (false) bewegt **/
    public final boolean linksbewegen;
    /** Gibt die Fabre des Hindernis an **/
    public final Color farbe;
    /** Gibt die Länge des Hindernis an **/
    protected int laenge;
    /** Gibt die Hitboxlänge des Hindernis an **/
    protected int hitboxLaenge;
    /** Gibt die Hitboxbreite des Hindernis an **/
    protected final int hitBoxBreite;
    /** Gibt an wie viel jedes Hindernis nach hinten versetzt wird **/
    protected final int setback;
    /** Gibt die Anzahl der Hindernisclone an **/
    protected final int anzahl;

    /** Kreiert ein neues Hindernis
     *
     * @param x_koordinate int
     * @param y_koordinate int
     * @param laenge int, Gibt die Länge des Autos an
     * @param linksbewegen boolean, Zeigt an ob das Auto nach links (true) oder rechts (false) fährt
     * @param farbe awt.Color, Gibt die Fabre des Autos an
     * @param geschwindigkeit int, Gibt die Geschwindigkeit des Autos an
     * @param anzahl int, Gibt die Anzahl der AutoClone an
     * @param hitboxBreite int, Gibt die Breite des Hindernis an
     * @param setback int, Gibt an wie wie viel jedes Hindernis nach hinten versetzt wird
     */

    protected Hindernis(
            int x_koordinate, int y_koordinate, int geschwindigkeit, int laenge,
            boolean linksbewegen, Color farbe, int anzahl, int hitboxBreite, int setback
    )
    {
        super(x_koordinate, y_koordinate, geschwindigkeit);
        this.laenge = laenge;
        this.linksbewegen = linksbewegen;
        this.anzahl = anzahl;
        this.hitBoxBreite = hitboxBreite;
        this.hitboxLaenge = laenge;
        this.setback = setback;
        this.farbe = farbe;
    }

    /** Erstellt einen Hindernis-Klon
     *
     * @return Hindernis, Gibt einen identischen Hindernis-Klon zurück
     */
    @Override
    protected Hindernis clone() {
        return new Hindernis(x_Koordinate-setback, y_Koordinate, geschwindigkeit, laenge, linksbewegen, farbe, anzahl, hitBoxBreite, setback);
    }

    /**
     * Testet, ob das Hindernis mit dem Frosch am selben Ort sind
     * @param frosch Aktuell vom Spieler gesteuerter Frosch
     * @return true, wenn der Frosch und das Hindernis-Objekt über die gleichen X und Y-Koordinaten verfügen
     */
    @Override
    public boolean kollidieren(Frosch frosch) {
        for (int laengeFrosch = 0; laengeFrosch < frosch.hitBoxLaenge; laengeFrosch++) {
            for (int laengeHindernis = 0; laengeHindernis < hitboxLaenge; laengeHindernis++) {
                for (int breiteFrosch = 0; breiteFrosch < frosch.hitBoxBreite; breiteFrosch++) {
                    for (int breiteHindernis = 0; breiteHindernis < hitBoxBreite; breiteHindernis++) {
                        if(frosch.x_Koordinate + laengeFrosch == x_Koordinate + laengeHindernis && frosch.y_Koordinate + breiteFrosch == y_Koordinate + breiteHindernis) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Bewegt das Hindernis-Element abhängig von der Bewegungsrichtung des Elements
     */
    protected void bewegen() {
        if(linksbewegen) {
            linksBewegen();

            if(x_Koordinate <= -20) {
                x_Koordinate = spiel.Menu.SPIELFELDLAENGE;
            }
        } else {
            rechtsBewegen();
            if(x_Koordinate >= Menu.SPIELFELDLAENGE + 20) {
                x_Koordinate = 0;

            }
        }
    }

    /**
     * Beschleunigt das Hinderniselement bei LevelUP
     * @param schneller beuschleunigt das Element um den schneller Betrag
     */
    protected void beschleunigen(int schneller) {
        if (geschwindigkeit > 1) {
            geschwindigkeit = geschwindigkeit + schneller;
        }
    }

    /**
     * Verkürzt das Hinderniselement bei LevelUP
     * @param kuerzer Verkürzt das Element um den kuerzer Betrag
     */
    protected void verkuerzen(int kuerzer) {
        if (laenge > 5) {
            laenge = laenge - kuerzer;
            hitboxLaenge = hitboxLaenge - kuerzer;
        }
    }

    /**
     * Verlaengert das Hinderniselement bei LevelUP
     * @param laenger Verlängert das Element um den laenger Betrag
     */
    protected void verlaengern(int laenger) {
        laenge = laenge + laenger;
        hitboxLaenge = hitboxLaenge + laenger;
    }
}
