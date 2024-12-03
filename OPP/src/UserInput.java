import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hallo, wer bist du denn");
        String name = sc.nextLine();

        boolean wahr = false;

        while (wahr == false) {
            System.out.println("Bitte versuche es erneut und gebe dein namen ein");
            name = sc.nextLine();
            if (!name.isEmpty()){
                wahr = true;
            }
        }
        System.out.println("Willkommen " + name + "!");
    }
}
