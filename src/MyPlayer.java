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

        // Count chips in each column
        for (int c = 0; c < 3; c++) {
            int count = 0;
            for (int r = 0; r < 3; r++) {
                if (gameBoard[r][c] != null) {
                    count++;
                }
            }
            columns[c] = count;
        }

        int c1 = columns[0];
        int c2 = columns[1];
        int c3 = columns[2];

        // Try every possible move
        for (int col = 1; col <= 3; col++) {
            int height = 0;
            if (col == 1) height = c1;
            if (col == 2) height = c2;
            if (col == 3) height = c3;

            for (int row = 1; row <= height; row++) {
                int nc1 = c1;
                int nc2 = c2;
                int nc3 = c3;

                if (col <= 1 && nc1 >= row) nc1 = row - 1;
                if (col <= 2 && nc2 >= row) nc2 = row - 1;
                if (col <= 3 && nc3 >= row) nc3 = row - 1;

                if (nc2 > nc1) nc2 = nc1;
                if (nc3 > nc2) nc3 = nc2;

                if ((nc1 == 1 && nc2 == 0 && nc3 == 0) ||
                        (nc1 == 2 && nc2 == 1 && nc3 == 0)) {
                    System.out.println("Winning move: col=" + (col - 1) + " row=" + (row - 1));
                    return new Point(col - 1, row - 1);
                }
            }
        }

        // Fallback: first legal move
        for (int c = 0; c < 3; c++) {
            if (columns[c] > 0) {
                System.out.println("Fallback move: col=" + c + " row=" + (columns[c] - 1));
                return new Point(c, columns[c] - 1);
            }
        }

        return new Point(0, 0);
    }
}