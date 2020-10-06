package spiel;

import spielumwelt.vordergrund.froesche.Frosch;

import java.awt.event.KeyEvent;

public class Eingabe {
    private final GAMEVIEW gameView;
    private final Frosch spielerFrosch;

    /** Ermöglicht das Einlesen von Richtungs- und Entereingaben für den gesteuerten Frosch**/
    public Eingabe() {
        gameView = Menu.gameView;
        spielerFrosch = null;
    }

    public Eingabe(Frosch spielerFrosch) {
        gameView = Menu.gameView;
        this.spielerFrosch = spielerFrosch;
    }


    /** Auslesen von Richtungseingaben des gesteuerten Frosches **/
    public void eingeben(NachrichtElement nachrichtElement) throws Exception {
        Integer[] gedruekteTasten = gameView.getKeyCodesOfCurrentlyPressedKeys();
        for(Integer keyEvent : gedruekteTasten) {
            if ( keyEvent == KeyEvent.VK_UP) {
                nachrichtElement.zeigenOderVerstecken = false;
                spielerFrosch.obenBewegen();
            } else if (keyEvent == KeyEvent.VK_RIGHT){
                nachrichtElement.zeigenOderVerstecken = false;
                spielerFrosch.rechtsBewegen();
            } else if (keyEvent == KeyEvent.VK_DOWN){
                nachrichtElement.zeigenOderVerstecken = false;
                spielerFrosch.untenBewegen();
            } else if (keyEvent == KeyEvent.VK_LEFT){
                nachrichtElement.zeigenOderVerstecken = false;
                spielerFrosch.linksBewegen();
            } else {
                throw new Exception("Es wurde keine gültige Pfeiltaste gedrückt");
            }
        }
    }

    /** Einlesen der Entertaste zum Spielstarten **/
    public boolean starten() throws Exception {
        Integer[] gedruekteTasten = gameView.getKeyCodesOfCurrentlyPressedKeys();
        for(Integer keyEvent : gedruekteTasten) {
            if (keyEvent == KeyEvent.VK_ENTER) {
                return true;
            } else {
                throw new Exception("Es wurde nicht die Enter Taste gedrückt");
            }
        }
        return false;
    }
}
