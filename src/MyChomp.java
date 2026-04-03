public class MyChomp {

    public static void main(String[] args) {

        boolean[][][] lose = new boolean[4][4][4];
        lose[1][0][0] = true;

        for (int c1 = 1; c1 <= 3; c1++) {
            for (int c2 = 0; c2 <= c1; c2++) {
                for (int c3 = 0; c3 <= c2; c3++) {

                    if (c1 == 1 && c2 == 0 && c3 == 0) {
                        System.out.println("LOSE (" + c1 + "," + c2 + "," + c3 + ")");
                        System.out.println("Best move: none");
                        System.out.println();
                        continue;
                    }

                    boolean win = false;

                    int bestCol = -1;
                    int bestRow = -1;
                    int bestC1 = -1;
                    int bestC2 = -1;
                    int bestC3 = -1;

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


                                if (!(nc1 == 0 && nc2 == 0 && nc3 == 0)) {
                                    if (lose[nc1][nc2][nc3]) {
                                        win = true;

                                        if (bestCol == -1) {
                                            bestCol = col;
                                            bestRow = row;
                                            bestC1 = nc1;
                                            bestC2 = nc2;
                                            bestC3 = nc3;
                                    }
                                }
                            }
                        }
                    }

                        if (win) {
                            System.out.println("WIN  (" + c1 + "," + c2 + "," + c3 + ")");
                            lose[c1][c2][c3] = false;
                            System.out.println("Best move: col " + bestCol + ", row " + bestRow
                                    + " -> (" + bestC1 + "," + bestC2 + "," + bestC3 + ")");
                        } else {
                            System.out.println("LOSE (" + c1 + "," + c2 + "," + c3 + ")");
                            lose[c1][c2][c3] = true;
                            System.out.println("Best move: none (no move leads to a losing board)");
                        }

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

                                if (!(nc1 == 0 && nc2 == 0 && nc3 == 0)) {
                                    System.out.println(" -> (" + nc1 + "," + nc2 + "," + nc3 + ")");
                                }
                            }
                        }

                    System.out.println();
                }
            }
        }
    }
}