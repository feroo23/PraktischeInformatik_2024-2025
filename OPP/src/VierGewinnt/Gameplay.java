package VierGewinnt;

import java.util.Scanner;

public class Gameplay {

    // Attribute
    private static Spielfeld feld = new Spielfeld();
    private static String[] spielernamen = new String[2];
    private Scanner sc = new Scanner(System.in);

    // Main-Methode
    public static void main(String[] args) {
        Gameplay spiel = new Gameplay();
        spiel.addSpieler();
        boolean spielLäuft = true;
        int aktuellerSpieler = 0;

        while (spielLäuft) {
            feld.anzeigen(); // Spielfeld anzeigen
            System.out.println(spielernamen[aktuellerSpieler] + " ist am Zug.");

            int spalte = spiel.spaltenAbfrage(aktuellerSpieler + 1);
            boolean erfolgreich = feld.steinEinwerfen(spalte - 1, aktuellerSpieler + 1);

            //Sieg dings kommt rein
            // if ()

            if (!erfolgreich) {
                System.out.println("Diese Spalte ist voll. Wähle eine andere.");
                continue;
            }

            aktuellerSpieler = (aktuellerSpieler + 1) % 2;
        }
    }

    // Spielernamen initialisieren
    public void addSpieler() {
        System.out.println("Willkommen bei Vier Gewinnt!");
        for (int i = 0; i < 2; i++) {
            System.out.print("Name von Spieler " + (i + 1) + ": ");
            spielernamen[i] = sc.nextLine();
        }
    }

    // Spalteneingabe vom Spieler abfragen
    public int spaltenAbfrage(int spielerID) {
        int spaltenAuswahl;
        boolean gueltigeEingabe = false;

        do {
            System.out.print("Spieler " + spielernamen[spielerID - 1] + ", wähle eine Spalte von 1 - 7: ");
            while (!sc.hasNextInt()) {
                System.out.println("Das ist keine gültige Zahl. Bitte versuche es erneut.");
                sc.next();
            }
            spaltenAuswahl = sc.nextInt();
            if (spaltenAuswahl >= 1 && spaltenAuswahl <= 7) {
                gueltigeEingabe = true;
            } else {
                System.out.println("Falsche Eingabe. Bitte wähle eine Zahl zwischen 1 und 7.");
            }
        } while (!gueltigeEingabe);
        return spaltenAuswahl;
    }
}
