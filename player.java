import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        initBoard();
        System.out.println("🎮 Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameOver) {
            System.out.print("Player " + currentPlayer + " enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (!isValidMove(row, col)) {
                System.out.println("❌ Invalid move! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            if (hasWon(currentPlayer)) {
                System.out.println("🏆 Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                System.out.println("🤝 It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        sc.close();
    }

    private static void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    private static boolean hasWon(char player) {
        // Check rows & columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }
}
