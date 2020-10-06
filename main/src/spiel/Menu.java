package spiel;

import java.awt.*;

public class Menu {
    /** Das Gameview zur Spiel- und Menüausgabe **/
    public static GAMEVIEW gameView;
    /** Spielfeldlänge**/
    public static final int SPIELFELDLAENGE = 78;
    /** Feedback Elment des Spielmenus */
    private int highScore;
    private final NachrichtElement nachrichtElement;
    private final Eingabe eingabe;
    private Spiel spiel;
    private final Regeln regeln;
    private int letzteScore;

    /** Kreiert ein neues Spielmenü aus dem ein neues Spiel gestartet werden kann **/
    public Menu() {
        gameView = new GAMEVIEW(39, SPIELFELDLAENGE,3);
        gameView.setTitle("Frogger");
        gameView.setWindowIcon("frog.png"); // Referenz funktioniert irgendwie nicht
        gameView.setStatusText("Tobias Hassebrock Java Programmierung SS 2020");
        gameView.playSound("tet.wav", true);

        eingabe = new Eingabe();
        nachrichtElement = new NachrichtElement(20, 35, false);
        spiel = new Spiel(highScore);
        regeln = new Regeln(5, 6);

        letzteScore = 0;
        highScore = 0;
    }

    /** startet neues Spiel **/
    public void neuesSpiel() {
        if (letzteScore != 0) {
            zwischenStandAusgeben();
        } else {
            regeln.ausgeben();
        }
        boolean starten = false;
        while (!starten) {
            try {
                starten = eingabe.starten();
            } catch (Exception e) {
                String errorNachricht = "  Du hast nicht die Enter Taste gedrückt.\n Bitte drück die Entertaste um zu starten!";
                nachrichtElement.zeigenOderVerstecken = true;
                nachrichtElement.nachricht = errorNachricht;
                if (nachrichtElement.zeigenOderVerstecken) {
                    gameView.addToCanvas(nachrichtElement.nachricht , nachrichtElement.y_Koordinate, nachrichtElement.x_Koordinate, Color.red);
                    gameView.printCanvas();
                }
            }
        }
        if (starten) {
            int[] ergebnisse = spiel.spielRundeSpielen();
            if (ergebnisse[0] != 0) {
                anderesSpiel(ergebnisse);
            }
        }
    }

    private void zwischenStandAusgeben() {
        gameView.clearCanvas();
        gameView.clearCanvas();
        gameView.addToCanvas("* Zwischenergebnisse! Nochmal? *", 10, 24);
        gameView.addToCanvas("Ihre letzte Score war:      " + letzteScore, 15, 25, Color.red);
        gameView.addToCanvas("Ihre Highscore ist:         " + highScore, 20, 25, Color.GREEN);
        gameView.addToCanvas("** Druecke Enter für ein Neues Spiel! **", 25, 20);
        gameView.printCanvas();
    }

    private void anderesSpiel(int[] ergebnisse) {
        letzteScore = ergebnisse[0];
        highScore = ergebnisse[1];
        spiel = new Spiel(highScore);
        neuesSpiel();
    }
}
