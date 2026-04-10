import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[3];
    }

    public Point move(Chip[][] pBoard) {
        System.out.println("MyPlayer Move");

        gameBoard = pBoard;

        // Count alive chips in each column on the 3x3 board
        for (int col = 0; col < 3; col++) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                if (gameBoard[row][col].isAlive) {
                    count++;
                }
            }
            columns[col] = count;
        }

        int a = columns[0];
        int b = columns[1];
        int c = columns[2];

        // Try reducing column 3
        if (c > 0) {
            for (int x = 1; x <= c; x++) {
                int na = a;
                int nb = b;
                int nc = c - x;

                if (na == 1 && nb == 0 && nc == 0) {
                    System.out.println("match in col 3");
                    return new Point(nc, 2);
                }
            }
        }
        // Try reducing column 2
        if (b > 0) {
            for (int x = 1; x <= b; x++) {
                int na = a;
                int nb = b - x;
                int nc = c;

                if (nb < nc) {
                    nc = nb;
                }

                if (na == 1 && nb == 0 && nc == 0) {
                    System.out.println("match in col 2");
                    return new Point(nb, 1);
                }
            }
        }

        // Try reducing column 1
        if (a > 0) {
            for (int x = 1; x <= a; x++) {
                int na = a - x;
                int nb = b;
                int nc = c;

                if (na < nb) {
                    nb = na;
                }
                if (nb < nc) {
                    nc = nb;
                }

                if (na == 1 && nb == 0 && nc == 0) {
                    System.out.println("match in col 1");
                    return new Point(na, 0);
                }
            }
        }

        // Fallback: choose the top alive chip in the rightmost non-empty column
        for (int col = 2; col >= 0; col--) {
            if (columns[col] > 0) {
                return new Point(columns[col] - 1, col);
            }
        }

        return new Point(0, 0);
    }
}