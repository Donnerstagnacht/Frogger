package spielumwelt.vordergrund.hindernisse;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Hindernisse {
    /** Array aus Auto[] indem sich alle Autos des Spielfelds sortiert nach der Reihe befinden **/
    public final Hindernis[][] hindernisse;

    /** Erstellt einen neuen Array aus Auto[] in dem sich alle Autos des Spielfelds sortiert nach der Reihe befinden **/
    public Hindernisse() {
        Baumstamm Baum1 = new Baumstamm(60, 6, 1, 14, true, Color.WHITE, 4/*4*/,3,0);
        Baumstamm Baum2 = new Baumstamm(10, 10, 2, 8, false, Color.CYAN, 8/*8*/,3,0);
        Baumstamm Baum3 = new Baumstamm(40, 14, 1, 12, true, Color.MAGENTA, 5 /*5*/,3,0);
        Auto auto4 = new Auto(30, 22, 1, 6, false, Color.blue, 4/*4*/,3,0);
        Auto auto5 = new Auto(20, 26,3, 3, false, Color.RED,1/*3*/,3,50);
        Auto auto6 = new Auto(10, 30,1, 3, true, Color.yellow, 5/*6*/,3,0);

        Baumstamm[] baueme1 = new Baumstamm[10];
        Baumstamm[] baueme2 = new Baumstamm[10];
        Baumstamm[] baueme3 = new Baumstamm[10];
        Auto[] autos4 = new Auto[10];
        Auto[] autos5 = new Auto[10];
        Auto[] autos6 = new Auto[10];

        baueme1[0] = Baum1;
        baueme2[0] = Baum2;
        baueme3[0] = Baum3;
        autos4[0] = auto4;
        autos5[0] = auto5;
        autos6[0] = auto6;

        hindernisse = new Hindernis[][]{baueme1, baueme2, baueme3, autos4, autos5, autos6};
    }

    /** Bewegt alle Hindernisse mit ihrer jeweiligen Geschwindigkeit vorwärts **/
    public void alleHindernisseBewegen() {
        for (Hindernis[] hindernisse: hindernisse) {
            bewegen(hindernisse);
        }
    }

    /**
     * Beschleunigt alle Hindernisgruppen
     * @param schneller Betrag um den alle Hindernisgruppen beschleunigt werden sollen
     */
    public void alleHindernisseBeschleunigen(int schneller) {
        for (Hindernis[] hindernisse: hindernisse) {
            beschleunigen(hindernisse, schneller);
        }
    }

    /**
     * Verändert die Länge aller Hindernisgrupppen
     * @param veraenderung Betrag um den alle Hindernisgruppen verlängert werden sollen
     */
    public void alleHindernisseLaengeVeraendern(int veraenderung) {
        for (Hindernis[] hindernisse: hindernisse) {
            laengeAendern(hindernisse, veraenderung);
        }
    }

    /** Clont Hindernisse bis die angegebene Anzahl Hindernisse erreicht wird
     *
     * @param hindernisse Hindernis[], Array, dass das zu klonende Hindernis enthält und in
     *              das die geklonten Hindernisse eingefügt werden
     */
    public void hindernisClonen(Hindernis[] hindernisse) {
        for (int start = 0; start <= hindernisse[start].anzahl-1; start++){
            if(hindernisse[start] instanceof Hindernis) {
                    Hindernis hindernisCopy = hindernisse[start].clone();
                    hindernisHinzufuegen(hindernisCopy, hindernisse);
            }
        }
    }

    private void hindernisHinzufuegen(Hindernis hindernis, Hindernis[] hindernisse) {
        for(int start = 0; start <= hindernisse.length-1; start++) {
            if(!(hindernisse[start] instanceof Hindernis) && hindernis instanceof Baumstamm) {
                hindernisse[start] = hindernis;
                int zurueck = start *hindernis.laenge / 2 + (hindernisse[start].geschwindigkeit + hindernisse[start].anzahl + ThreadLocalRandom.current().nextInt(1, 10 + 1) + hindernis.setback);
                hindernisse[start].x_Koordinate = hindernisse[start].x_Koordinate + zurueck;
                break;
            } else if (!(hindernisse[start] instanceof Hindernis) && hindernis instanceof Auto) {
                hindernisse[start] = hindernis;
                int zurueck = start * hindernis.laenge / 2+ (hindernisse[start].geschwindigkeit + hindernisse[start].anzahl + ThreadLocalRandom.current().nextInt(1, 10 + 1));
                hindernisse[start].x_Koordinate = hindernisse[start].x_Koordinate + zurueck;
                break;
            }
        }
    }

    private void bewegen(Hindernis[] hindernisse) {
        for (Hindernis hindernis:hindernisse) {
            if(hindernis instanceof Hindernis) {
                hindernis.bewegen();
            }
        }
    }

    private void beschleunigen(Hindernis[] hindernisse, int schneller) {
        for (Hindernis hindernis:hindernisse) {
            if (hindernis instanceof Hindernis) {
                hindernis.beschleunigen(schneller);
            }
        }
    }

    private void laengeAendern(Hindernis[] hindernisse, int aenderung) {
        for (Hindernis hindernis:hindernisse) {
            if (hindernis instanceof  Baumstamm) {
                hindernis.verkuerzen(aenderung);
            } else if (hindernis instanceof Auto) {
                hindernis.verlaengern(aenderung);
            }
        }
    }

}
