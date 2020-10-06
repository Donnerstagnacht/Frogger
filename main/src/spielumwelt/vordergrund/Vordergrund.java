package spielumwelt.vordergrund;
import spiel.Menu;
import spielumwelt.vordergrund.hindernisse.Auto;
import spielumwelt.vordergrund.hindernisse.Baumstamm;
import spielumwelt.vordergrund.hindernisse.Hindernis;
import spielumwelt.vordergrund.hindernisse.Hindernisse;
import spielumwelt.vordergrund.froesche.Froesche;
import spielumwelt.vordergrund.froesche.Frosch;

import java.awt.*;

public class Vordergrund {
    /** Frosch-Element des aktuellen Spielfelds **/
    public final Frosch spielerFrosch;
    /** Autos-Element des aktuellen Spielfelds **/
    public final Hindernisse hindernisse;
    public final Froesche froesche;

    /** Kreiert ein neues Spielfeld **/
    public Vordergrund() {
        hindernisse = new Hindernisse();
        froesche = new Froesche();
        spielerFrosch = new Frosch(38,34, 4);
    }

    /** Erstellt einen neuen Frosch Klon, wenn die andere Straßenseite erreicht wurde**/
    public boolean andereStrassenSeiteErreicht() {
        if(spielerFrosch.y_Koordinate == 2) {
            froesche.froschHinzufuegen(spielerFrosch);
            spielerFrosch.y_Koordinate = 34;
            spielerFrosch.x_Koordinate = 38;
            return true;
        }
        return false;
    }

    /** Gibt das aktuelle Spielfeld aus **/
    public void ausgeben() {
        for (Hindernis[] hindernisse: hindernisse.hindernisse) {
            for (Hindernis hindernis:hindernisse) {
                if(hindernis instanceof Auto) {
                    Menu.gameView.addToCanvas(hindernis.toString(), hindernis.y_Koordinate, hindernis.x_Koordinate, hindernis.farbe);
                } else if (hindernis instanceof Baumstamm) {
                    Menu.gameView.addToCanvas(hindernis.toString(), hindernis.y_Koordinate, hindernis.x_Koordinate, hindernis.farbe);
                }
            }
        }
        for (Frosch frosch: froesche.froesche) {
            if(frosch instanceof Frosch) {
                Menu.gameView.addToCanvas(frosch.toString(), frosch.y_Koordinate, frosch.x_Koordinate);
            }
        }
        Menu.gameView.addToCanvas(spielerFrosch.toString(), spielerFrosch.y_Koordinate, spielerFrosch.x_Koordinate, Color.black);
    }
}
