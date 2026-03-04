public class MyChomp {

    public static void main(String[] args) {

        for (int r1 = 1; r1 <= 3; r1++) {
            for (int r2 = 0; r2 <= r1; r2++) {
                for (int r3 = 0; r3 <= r2; r3++) {

                    System.out.println("Board: (" + r1 + "," + r2 + "," + r3 + ")");

                    for (int row = 1; row <= 3; row++) {

                        int rowLength = 0;
                        if (row == 1) rowLength = r1;
                        if (row == 2) rowLength = r2;
                        if (row == 3) rowLength = r3;

                        for (int col = 1; col <= rowLength; col++) {

                            int nr1 = r1;
                            int nr2 = r2;
                            int nr3 = r3;

                            if (row >= 1 && nr1 >= col) nr1 = col - 1;
                            if (row >= 2 && nr2 >= col) nr2 = col - 1;
                            if (row >= 3 && nr3 >= col) nr3 = col - 1;

                            if (nr2 > nr1) nr2 = nr1;
                            if (nr3 > nr2) nr3 = nr2;

                            if (!(nr1 == 0 && nr2 == 0 && nr3 == 0)) {
                                System.out.println(" -> (" + nr1 + "," + nr2 + "," + nr3 + ")");
                            }
                        }
                    }

                    System.out.println();
                }
            }
        }
    }
}