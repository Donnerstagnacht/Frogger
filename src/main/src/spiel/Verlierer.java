package spiel;

import spielumwelt.vordergrund.froesche.Frosch;
import spielumwelt.vordergrund.hindernisse.Baumstamm;
import spielumwelt.vordergrund.hindernisse.Hindernis;

public class Verlierer {
    private final Frosch spielerFrosch;
    private final Hindernis[][] hindernisse;
    private final Frosch[] froesche;
    private final int trennerOben;
    /** true = unten, false = oben*/
    private boolean modus;
    private boolean verloren;

    /** Ermöglicht die Überprüfung, ob das Spiel verloren worden ist **/
    public Verlierer(Hindernis[][] hindernisse, Frosch[] froesche, Frosch spielerFrosch) {
        this.spielerFrosch = spielerFrosch;
        this.hindernisse = hindernisse;
        this.froesche = froesche;
        trennerOben = 17;
        verloren = false;
    }

    /** Testet, ob der Frosch das Spielfeld verlassen und daher verloren hat
     *
     * @return true, wenn der Frosch verloren hat,
     * false, wenn der Frosch nicht verloren hat
     */
    public boolean spielfeldVerlassen() {
        if (spielerFrosch.x_Koordinate <= 0) {
            verloren = true;
        } else if(spielerFrosch.x_Koordinate >= Menu.SPIELFELDLAENGE) {
            verloren = true;
        }
        return verloren;
    }

    /** Testet, ob der Spieler durch Unfall oder Runterfallen verloren hat
     * @return true,  wenn der Frosch verloren hat
     *  false, wenn der Frosch nicht verloren hat
     */
    public boolean ertrinkenOderUnfall() {
        if(spielerFrosch.y_Koordinate >= trennerOben) {
            modus = true;
            gleicherOrtSpielfeldTesten();
        } else {
            modus = false;
            Hindernis aufgesprungenerBaumstamm = gleicherOrtSpielfeldTesten();
            mitFahrenAufgesprungenerBaum(aufgesprungenerBaumstamm);
        }
        return verloren;
    }

    /**
     * Testet ob zwei Frösche an der selben Stelle auf der sicheren Seite stehen
     * @return true, wenn zwei Frösche an der gleichen Stelle stehen
     */
    public boolean gleicherFroschImZiel() {
        boolean gleicheKoordinate;

        for (Frosch frosch: froesche) {
            if(frosch instanceof Frosch) {
                for(int laengeFrosch = 0; laengeFrosch < frosch.hitBoxLaenge; laengeFrosch++) {
                    gleicheKoordinate = spielerFrosch.kollidieren(frosch);
                    if(gleicheKoordinate) {
                        return verloren = true;
                    } else {
                        verloren = false;
                    }
                }
            }
        }
        return verloren;
    }

    private Hindernis gleicherOrtSpielfeldTesten() {
        boolean gleicheKoordinate;

        for (spielumwelt.vordergrund.hindernisse.Hindernis[] hindernisse: hindernisse) {
            for (Hindernis hindernis: hindernisse) {
                if(hindernis instanceof Hindernis) {
                    for(int laengeFrosch = 0; laengeFrosch < spielerFrosch.hitBoxLaenge; laengeFrosch++) {
                        gleicheKoordinate = hindernis.kollidieren(spielerFrosch);
                        if(modus) {
                            if(gleicheKoordinate) {
                                verloren = true;
                                return hindernis;
                            }
                        } else {
                            if (gleicheKoordinate) {
                                verloren = false;
                                return hindernis;
                            } else {
                                verloren = true;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private void mitFahrenAufgesprungenerBaum(Hindernis aufgesprungenerBaumstamm) {
        if(aufgesprungenerBaumstamm instanceof Baumstamm && aufgesprungenerBaumstamm.linksbewegen) {
            spielerFrosch.x_Koordinate = spielerFrosch.x_Koordinate - aufgesprungenerBaumstamm.geschwindigkeit;
        } else if (aufgesprungenerBaumstamm instanceof  Baumstamm && !aufgesprungenerBaumstamm.linksbewegen) {
            spielerFrosch.x_Koordinate = spielerFrosch.x_Koordinate + aufgesprungenerBaumstamm.geschwindigkeit;
        }
    }

}
