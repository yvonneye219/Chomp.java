import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        // columns[i] = number of alive chips in column i
        columns = new int[3];
    }

    public Point move(Chip[][] pBoard) {
        System.out.println("MyPlayer Move");

        // Store current board
        gameBoard = pBoard;

        //Count how many chips are alive in each column
        for (int col = 0; col < 3; col++) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                if (gameBoard[row][col].isAlive) {
                    count++;
                }
            }
            columns[col] = count;
        }

        // Rename for easier thinking (column heights)
        int a = columns[0]; // left column
        int b = columns[1]; // middle column
        int c = columns[2]; // right column

        // CORE IDEA:
        // Try every possible move → simulate the result →
        // check if it leaves opponent in a LOSING state

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < columns[col]; row++) {

                // Copy current state
                int na = a;
                int nb = b;
                int nc = c;

                // Simulate clicking (row, col)
                // In Chomp: clicking removes everything ABOVE and to the RIGHT

                if (col <= 0 && na > row) na = row;
                if (col <= 1 && nb > row) nb = row;
                if (col <= 2 && nc > row) nc = row;

                // Fix shape (columns must decrease left → right)
                if (nb > na) nb = na;
                if (nc > nb) nc = nb;

                // Check if this is a WINNING move
                // Known losing state: (1,0,0)
                if (na == 1 && nb == 0 && nc == 0) {
                    System.out.println("Winning move found");
                    return new Point(row, col); // return that move
                }
            }
        }

        // Smart opening move
        // If board is still large, take center (1,1)
        if (columns[1] > 1) {
            return new Point(1, 1);
        }

        // Fallback strategy
        // Take the top chip in the rightmost non-empty column
        for (int col = 2; col >= 0; col--) {
            if (columns[col] > 0) {
                return new Point(columns[col] - 1, col);
            }
        }

        // Worst case (should not happen)
        return new Point(0, 0);
    }
}