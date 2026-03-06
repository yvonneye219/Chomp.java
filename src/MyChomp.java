public class MyChomp {

    public static void main(String[] args) {

        boolean[][][] lose = new boolean[4][4][4];

        for (int c1 = 1; c1 <= 3; c1++) {
            for (int c2 = 0; c2 <= c1; c2++) {
                for (int c3 = 0; c3 <= c2; c3++) {

                    if (c1 == 1 && c2 == 0 && c3 == 0) {
                        System.out.println("LOSE (" + c1 + "," + c2 + "," + c3 + ")");
                        System.out.println();
                        continue;
                    }

                    boolean win = false;

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


                                // check if move leads to a lose board
                                if ((nc1 == 1 && nc2 == 0 && nc3 == 0) ||
                                        (nc1 == 2 && nc2 == 1 && nc3 == 0)) {
                                    win = true;
                                }
                            }
                        }
                    }

                    if (win)
                        System.out.println("WIN  (" + c1 + "," + c2 + "," + c3 + ")");
                    else
                        System.out.println("LOSE (" + c1 + "," + c2 + "," + c3 + ")");


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