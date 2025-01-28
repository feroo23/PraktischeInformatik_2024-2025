import java.util.Scanner;

public class VierGewinn {

    // Spielfeldgröße
    private static final int ROWS = 6; // Zeilen
    private static final int COLUMNS = 7; // Spalten

    public static void main(String[] args) {
        // Spielfeld erstellen
        char[][] board = new char[ROWS][COLUMNS];
        initializeBoard(board);

        System.out.println("Willkommen bei Vier Gewinnt!");
        printBoard(board);

        Scanner scanner = new Scanner(System.in);
        boolean isPlayerOne = true; // Start mit Spieler 1
        boolean gameWon = false;

        // Hauptspiel-Schleife
        while (!gameWon && !boardIsFull(board)) {
            System.out.println("Spieler " + (isPlayerOne ? "1 [X]" : "2 [O]") + ", wähle eine Spalte (1-7):");
            int column;

            // Gültige Spalten-Eingabe vom Spieler
            while (true) {
                column = scanner.nextInt() - 1; // Spalte von 1-basiert auf 0-basiert umwandeln
                if (column >= 0 && column < COLUMNS && board[0][column] == '.') {
                    break;
                }
                System.out.println("Ungültige Eingabe. Wähle eine andere Spalte:");
            }

            // Stein in der Spalte setzen
            makeMove(board, column, isPlayerOne ? 'X' : 'O');
            printBoard(board);

            // Überprüfen, ob das Spiel gewonnen wurde
            if (checkWin(board)) {
                gameWon = true;
                System.out.println("Spieler " + (isPlayerOne ? "1 [X]" : "2 [O]") + " hat gewonnen!");
            }

            // Wechseln zum nächsten Spieler
            isPlayerOne = !isPlayerOne;
        }

        // Falls das Spielfeld voll ist und niemand gewonnen hat
        if (!gameWon) {
            System.out.println("Unentschieden! Das Spielfeld ist voll.");
        }

        scanner.close();
    }

    // Spielfeld initialisieren
    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = '.';
            }
        }
    }

    // Spielfeld drucken
    private static void printBoard(char[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7"); // Spaltennummerierung
    }

    // Spielzug ausführen
    private static void makeMove(char[][] board, int column, char playerToken) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == '.') {
                board[i][column] = playerToken;
                break;
            }
        }
    }

    // Überprüfung auf Gewinnbedingungen
    private static boolean checkWin(char[][] board) {
        // Horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] != '.' &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2] &&
                        board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }

        // Vertikal
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[row][col] != '.' &&
                        board[row][col] == board[row + 1][col] &&
                        board[row][col] == board[row + 2][col] &&
                        board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }

        // Diagonal (von links unten nach rechts oben)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] != '.' &&
                        board[row][col] == board[row - 1][col + 1] &&
                        board[row][col] == board[row - 2][col + 2] &&
                        board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }

        // Diagonal (von links oben nach rechts unten)
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] != '.' &&
                        board[row][col] == board[row + 1][col + 1] &&
                        board[row][col] == board[row + 2][col + 2] &&
                        board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Überprüfung, ob das Spielfeld voll ist
    private static boolean boardIsFull(char[][] board) {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == '.') {
                return false; // Zumindest eine Spalte ist noch frei
            }
        }
        return true;
    }
}