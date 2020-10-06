package spiel;

import spielumwelt.CanvasKomponente;

public class Regeln extends CanvasKomponente {

    /**
     * Erstellt Element, dass die Regeln ausgeben kann
     * @param x_koordinate x-Koordinate an der die Regeln angezeigt werden sollen
     * @param y_koordinate y-Koordinate an der die Regeln angezeigt werden sollen
     */
    public Regeln(int x_koordinate, int y_koordinate) {
        super(x_koordinate, y_koordinate);
    }


    /** Gibt die Regeln aus */
    public void ausgeben() {
        Menu.gameView.printCentred(toString());
    }

    /** Baut den String zur Ausgabe der Regeln. Besser die Funktion ausgeben benutzen */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                "                 WILLKOMMMEN BEI FROGGER      \n\n\n\n" +
                "                        * Ziel *\n\n" +
                "  Das Ziel des Spiels ist deinen Frosch über die Straße und\n" +
                "     den Fluss auf die andere Seite der Karte zu bringen.\n\n\n" +
                "    Dabei darfst du weder einen Unfall mit einem\n" +
                "        Auto haben oder im Fluss ertrinken. \n\n\n" +
                "        Außerdem darfst du das Spielfeld nicht nach\n" +
                "                links oder rechts verlassen.\n\n\n" +
                "    Jedes Mal, wenn du die andere Seite erreichst, erhälst\n" +
                "        du Bonuspunkte und das Spiel wird schwerer\n\n\n" +
                "         Du darfst die andere Seite aber nicht zweimal\n"+
                "              an der selben Stelle erreichen.\n\n\n\n\n" +
                "                     ** Steuerung ** \n\n\n" +
                "Pfeiltaste oben drücken:        Frosch nach oben bewegen\n" +
                "Pfeiltaste rechts drücken:      Frosch nach rechts bewegen\n" +
                "Pfeiltaste unten drücken:       Frosch nach unten bewegen\n" +
                "Pfeiltaste links drücken:       Frosch nach links bewegen\n\n\n\n" +
                "        *** Drücke Enter um ein neues Spiel zu starten! ***"
        );

        return stringBuilder.toString();
    }

}
