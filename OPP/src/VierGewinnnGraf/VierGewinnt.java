package VierGewinnnGraf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VierGewinnt extends JFrame {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int TILE_SIZE = 80;
    private static final int PLAYER1 = 1;
    private static final int PLAYER2 = 2;
    private static final Color PLAYER1_COLOR = Color.RED;
    private static final Color PLAYER2_COLOR = Color.YELLOW;
    private static final int EMPTY = 0;

    private int[][] board;
    private int currentPlayer;
    private boolean gameOver;
    private JPanel boardPanel;
    private JLabel statusLabel;
    private JLabel scoreLabel;
    private JButton restartButton;
    private int player1Score = 0;
    private int player2Score = 0;

    public VierGewinnt() {
        // Fenster-Einstellungen
        setTitle("Vier Gewinnt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vollbildmodus aktivieren
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fenster maximieren
        //setUndecorated(true); // Fensterrahmen entfernen
        setVisible(true); // Fenster anzeigen

        // Spielfeld initialisieren
        board = new int[ROWS][COLS];
        currentPlayer = PLAYER1;
        gameOver = false;

        // Status-Label
        statusLabel = new JLabel("Spieler 1 ist am Zug", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(statusLabel, BorderLayout.NORTH);

        // Punktestand-Label
        scoreLabel = new JLabel("  Spieler 1: 0 | Spieler 2: 0  ", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(scoreLabel, BorderLayout.EAST );

        // Spielfeld-Panel
        boardPanel = new JPanel(new GridLayout(ROWS, COLS, 2, 2));
        boardPanel.setBackground(Color.BLUE); // Blauer Hintergrund für das Spielfeld
        initializeBoard();
        add(boardPanel, BorderLayout.CENTER);

        // Neustart-Button (zunächst unsichtbar)
        restartButton = new JButton("Nochmal spielen");
        restartButton.setFont(new Font("Arial", Font.BOLD, 16));
        restartButton.setVisible(false);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        add(restartButton, BorderLayout.SOUTH);

        // Fenster anzeigen
        setVisible(true);
    }

    private void initializeBoard() {
        // Spielfeld mit Buttons initialisieren
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JButton button = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        // Runde Blöcke zeichnen
                        if (getModel().isArmed()) {
                            g.setColor(Color.LIGHT_GRAY);
                        } else {
                            g.setColor(getBackground());
                        }
                        g.fillOval(2, 2, getSize().width - 4, getSize().height - 4); // Kleiner Rand für den Kreis
                        super.paintComponent(g);
                    }

                    @Override
                    protected void paintBorder(Graphics g) {
                        // Rand der runden Blöcke zeichnen
                        g.setColor(Color.BLACK);
                        g.drawOval(2, 2, getSize().width - 4, getSize().height - 4);
                    }
                };
                button.setBackground(Color.WHITE);
                button.setOpaque(false);
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!gameOver) {
                            JButton clickedButton = (JButton) e.getSource();
                            int col = boardPanel.getComponentZOrder(clickedButton) % COLS;
                            makeMove(col);
                        }
                    }
                });
                boardPanel.add(button);
            }
        }
    }

    private void makeMove(int col) {
        // Stein in der Spalte platzieren
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = currentPlayer;
                updateBoard();

                if (checkWin(row, col)) {
                    if (currentPlayer == PLAYER1) {
                        player1Score++;
                    } else {
                        player2Score++;
                    }
                    scoreLabel.setText("  Spieler 1: " + player1Score + " | Spieler 2: " + player2Score + " ");
                    statusLabel.setText("Spieler " + currentPlayer + " gewinnt!");
                    gameOver = true;
                    restartButton.setVisible(true); // Neustart-Button anzeigen
                    return;
                }

                if (isBoardFull()) {
                    statusLabel.setText("Unentschieden!");
                    gameOver = true;
                    restartButton.setVisible(true); // Neustart-Button anzeigen
                    return;
                }

                currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
                statusLabel.setText("Spieler " + currentPlayer + " ist am Zug");
                return;
            }
        }
    }

    private void updateBoard() {
        // Spielfeld aktualisieren
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JButton button = (JButton) boardPanel.getComponent(row * COLS + col);
                if (board[row][col] == PLAYER1) {
                    button.setBackground(PLAYER1_COLOR);
                } else if (board[row][col] == PLAYER2) {
                    button.setBackground(PLAYER2_COLOR);
                } else {
                    button.setBackground(Color.WHITE);
                }
            }
        }
    }

    private boolean checkWin(int row, int col) {
        // Überprüfen, ob ein Spieler gewonnen hat
        int[][] directions = {
                {1, 0},  // Vertikal
                {0, 1},  // Horizontal
                {1, 1},  // Diagonal rechts unten
                {1, -1}  // Diagonal links unten
        };

        for (int[] dir : directions) {
            int count = 1;
            // In eine Richtung suchen
            for (int i = 1; i < 4; i++) {
                int newRow = row + dir[0] * i;
                int newCol = col + dir[1] * i;
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && board[newRow][newCol] == currentPlayer) {
                    count++;
                } else {
                    break;
                }
            }
            // In die entgegengesetzte Richtung suchen
            for (int i = 1; i < 4; i++) {
                int newRow = row - dir[0] * i;
                int newCol = col - dir[1] * i;
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && board[newRow][newCol] == currentPlayer) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        // Überprüfen, ob das Spielfeld voll ist
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    private void restartGame() {
        // Spiel neu starten
        board = new int[ROWS][COLS];
        currentPlayer = PLAYER1;
        gameOver = false;
        statusLabel.setText("Spieler 1 ist am Zug");
        restartButton.setVisible(false); // Neustart-Button ausblenden
        updateBoard();
    }

    public static void main(String[] args) {
        // Spiel starten
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VierGewinnt();
            }
        });
    }
}