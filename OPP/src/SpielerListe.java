import java.util.ArrayList;
import java.util.Scanner;

public class SpielerListe {
    public static void  main(String[] args) throws InterruptedException {
        ArrayList<String> playerNames = new ArrayList<>();
        playerNames.add("Horst");
        playerNames.add("Bob");
        playerNames.add("Alice");
        playerNames.add("Carl");
        playerNames.add("Dan");


        System.out.println("\nDas sind deine jetzigen Spieler:" );
        for (int i = 0; i < playerNames.size(); i++) {
            System.out.println("\t" + playerNames.get(i));
        }

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    
                    [0] Abbrechen
                    [1] Spieler Hinzufügen
                    [2] Spieler Anzeigen
                    """);
            String playerAbfrage = input.nextLine();

            if (playerAbfrage.equalsIgnoreCase("1")){
                System.out.println("Wie soll dein Spiler heißen:");
                String playerNameNeu = input.nextLine();
                while (playerNameNeu.isEmpty()) {
                    System.out.println("Verscuhe es nochmal!");
                    playerNameNeu = input.nextLine();
                }
                System.out.println("Spieler hinzugefügt");
                playerNames.add(playerNameNeu);
            } else if (playerAbfrage.equalsIgnoreCase("0")) {
                System.out.println("\n\nHier siehst du nochmal deine Spieler in deiner Liste");
                for (int i = 0; i < playerNames.size(); i++) {
                    System.out.println("\t" + playerNames.get(i));
                }
                Thread.sleep(1000);
                System.out.println("\nBis zum Nächsten mal!");
                break;
            } else if (playerAbfrage.equalsIgnoreCase("2")) {
                for (int i = 0; i < playerNames.size(); i++) {
                    System.out.println("\t" + playerNames.get(i));
                }
            } else {
                Thread.sleep(500);
                System.out.println("\n\u001B[31mBitte verscuhe es erneut\u001B[0m");
            }
        }
    }
}
