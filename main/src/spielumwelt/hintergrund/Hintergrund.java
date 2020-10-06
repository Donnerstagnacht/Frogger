package spielumwelt.hintergrund;

import spiel.Menu;
import spiel.NachrichtElement;
import spielumwelt.vordergrund.froesche.Frosch;

import java.awt.*;

public class Hintergrund  {
    /** Nachrichten Element, dass Feedback Nachrichten für den Spieler anzeigt */
    public final NachrichtElement nachrichtElement;
    /** Status des level up: wird true, wenn ein neues Level erreicht wird */
    public boolean levelUp = false;
    /** Highscore-Element des aktuellen Hintergrunds **/
    public final Highscore highscore;
    /** Score-Element des aktuellen Hintergrunds **/
    public final punkteZaehler rundenScore;
    /** Score-Element des aktuellen Hintergrunds **/
    public final Zeit zeit;
    public final Level level;
    private final Trenner trennerOben;
    private final Trenner trennerMitteOben;
    private final Trenner trennerMitteUnten;
    private final Trenner trennerUnten;
    private final GruenStreifen gruenStreifenOben;
    private final GruenStreifen gruenStreifenMitte;
    private final GruenStreifen gruenStreifenUnten;
    private final Fluss fluss;
    private final StrassenBelag strassenBelag;

    /** Kreiert ein neues Hintergrund-Element **/
    public Hintergrund(Frosch spielerFrosch, int highScore) {
        highscore = new Highscore(2,0,highScore);
        nachrichtElement = new NachrichtElement(25, 0, true);
        level = new Level(68,0);

        trennerOben = new Trenner(0,1);
        gruenStreifenOben = new GruenStreifen(0,2);

        fluss = new Fluss(0,5, 14);

        trennerMitteOben = new Trenner(0,17);
        gruenStreifenMitte = new GruenStreifen(0,18);
        trennerMitteUnten = new Trenner(0,21);

        strassenBelag = new StrassenBelag(0,21, 14);

        gruenStreifenUnten = new GruenStreifen(0,34);
        trennerUnten = new Trenner(0,37);
        rundenScore = new punkteZaehler(2,38, 0, spielerFrosch);
        zeit = new Zeit(68,38, 0);
    }

    /** Gibt den aktuellen Hintergrund aus **/
    public void ausgeben() {
        Menu.gameView.addToCanvas(highscore.toString(), highscore.y_Koordinate, highscore.x_Koordinate);
        if(nachrichtElement.zeigenOderVerstecken && !levelUp) {
            if(nachrichtElement.nachricht != null) {
                Menu.gameView.addToCanvas(nachrichtElement.nachricht, nachrichtElement.y_Koordinate, nachrichtElement.x_Koordinate, Color.RED);
            }
        } else if (nachrichtElement.zeigenOderVerstecken && levelUp) {
            Menu.gameView.addToCanvas(nachrichtElement.nachricht, nachrichtElement.y_Koordinate, nachrichtElement.x_Koordinate, Color.GREEN);
        }
        Menu.gameView.addToCanvas(level.toString(), level.y_Koordinate, level.x_Koordinate);
        Menu.gameView.addToCanvas(rundenScore.toString(), rundenScore.y_Koordinate, rundenScore.x_Koordinate);
        Menu.gameView.addToCanvas(zeit.toString(), zeit.y_Koordinate, zeit.x_Koordinate);
        Menu.gameView.addColorStringToCanvas(gruenStreifenOben.toString(), gruenStreifenOben.y_Koordinate, gruenStreifenOben.x_Koordinate);

        Menu.gameView.addColorStringToCanvas(fluss.toString(), fluss.y_Koordinate, fluss.x_Koordinate);
        Menu.gameView.addColorStringToCanvas(strassenBelag.toString(), strassenBelag.y_Koordinate, strassenBelag.x_Koordinate);

        Menu.gameView.addToCanvas(trennerOben.toString(), trennerOben.y_Koordinate, trennerOben.x_Koordinate);
        Menu.gameView.addToCanvas(trennerMitteOben.toString(), trennerMitteOben.y_Koordinate, trennerMitteOben.x_Koordinate);
        Menu.gameView.addColorStringToCanvas(gruenStreifenMitte.toString(), gruenStreifenMitte.y_Koordinate, gruenStreifenMitte.x_Koordinate);
        Menu.gameView.addToCanvas(trennerMitteUnten.toString(), trennerMitteUnten.y_Koordinate, trennerMitteUnten.x_Koordinate);

        Menu.gameView.addColorStringToCanvas(gruenStreifenUnten.toString(), gruenStreifenUnten.y_Koordinate, gruenStreifenUnten.x_Koordinate);
        Menu.gameView.addToCanvas(trennerUnten.toString(), trennerUnten.y_Koordinate, trennerUnten.x_Koordinate);
    }
}
