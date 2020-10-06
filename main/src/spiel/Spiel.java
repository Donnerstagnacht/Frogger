package spiel;
import spielumwelt.hintergrund.Hintergrund;
import spielumwelt.vordergrund.Vordergrund;

public class Spiel {
    /** Hintergrund des aktuellen Spiels */
    private final Hintergrund hintergrund;
    private final Vordergrund vordergrund;
    private final Eingabe eingabe;
    private final Verlierer verlierer;
    private static final int SLEEP = 100;
    private final int[] ergebnisse = new int[2];

    /** Kreiert ein neues Spiel **/
    public Spiel(int highScore){
        vordergrund = new Vordergrund();
        hintergrund = new Hintergrund(vordergrund.spielerFrosch, highScore);
        eingabe = new Eingabe(vordergrund.spielerFrosch);
        verlierer = new Verlierer(vordergrund.hindernisse.hindernisse, vordergrund.froesche.froesche, vordergrund.spielerFrosch);
    }

    /** Spielt eine neue Runde **/
    public int[] spielRundeSpielen() {
        spielFeldBereitstellen();
        soundSpiel();

        while (true) {

            boolean verloren = verlierer.ertrinkenOderUnfall();
            if(verloren) {
                spielBeenden();
                return ergebnisse;
            }

            vordergrund.hindernisse.alleHindernisseBewegen();

            try {
                eingabe.eingeben(hintergrund.nachrichtElement);
            } catch (Exception e) {
                String errorNachricht = "Auf gehts's! Drück eine Pfeiltaste";
                hintergrund.nachrichtElement.zeigenOderVerstecken = true;
                hintergrund.nachrichtElement.nachricht = errorNachricht;
            }

            verloren = verlierer.spielfeldVerlassen();
            if(verloren) {
                spielBeenden();
                return ergebnisse;
            }

            verloren = verlierer.gleicherFroschImZiel();
            if(verloren) {
                spielBeenden();
                return ergebnisse;
            }

            spielAktualisieren();

            boolean levelUp = vordergrund.andereStrassenSeiteErreicht();
            levelErhoehen(levelUp);

            try {
                Thread.sleep(SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void spielFeldBereitstellen() {
        for (spielumwelt.vordergrund.hindernisse.Hindernis[] hindernisse: vordergrund.hindernisse.hindernisse) {
             vordergrund.hindernisse.hindernisClonen(hindernisse);
        }
    }

    private void soundSpiel() {
        Menu.gameView.playSound("carstart.wav", false);
        Menu.gameView.stopSound(1);
        Menu.gameView.playSound("frog.wav", false);
    }

    private void spielBeenden() {
        Menu.gameView.playSound("unfall.wav", false);
        Menu.gameView.stopAllSounds();
        ergebnisse[0] = hintergrund.rundenScore.zaehler;
        ergebnisse[1] = hintergrund.highscore.highScoreErhoehen(hintergrund.rundenScore);
        System.out.println(ergebnisse[1]);
    }

    private void spielAktualisieren() {
        Menu.gameView.clearCanvas();
        hintergrund.zeit.zaehlen(SLEEP);
        hintergrund.rundenScore.scoreErhoehen();
        hintergrund.ausgeben();
        vordergrund.ausgeben();
        Menu.gameView.printCanvas();
    }

    private void levelErhoehen(boolean levelUp) {
        if (levelUp) {
            if (hintergrund.level.zaehler < 8) {
                hintergrund.level.levelErhoehen();
                hintergrund.levelUp = true;
                hintergrund.nachrichtElement.zeigenOderVerstecken = true;
                hintergrund.nachrichtElement.nachricht = "Level Up! Es wird schwerer!";
                if (hintergrund.level.zaehler == 2) {
                    vordergrund.hindernisse.alleHindernisseLaengeVeraendern(1);
                } else if (hintergrund.level.zaehler == 3) {
                    vordergrund.hindernisse.alleHindernisseLaengeVeraendern(2);
                } else if (hintergrund.level.zaehler == 4 ) {
                    vordergrund.hindernisse.alleHindernisseLaengeVeraendern(2);
                } else if (hintergrund.level.zaehler == 5 ) {
                    vordergrund.hindernisse.alleHindernisseBeschleunigen(1);
                } else if (hintergrund.level.zaehler == 6 ) {
                    vordergrund.hindernisse.alleHindernisseLaengeVeraendern(2);
                } else if (hintergrund.level.zaehler == 7) {
                    vordergrund.hindernisse.alleHindernisseBeschleunigen(1);
                }
            }
        }
    }
}

