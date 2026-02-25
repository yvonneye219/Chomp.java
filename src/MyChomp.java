public class MyChomp {



    public static void main(String[] args) {

        for (int r1 = 1; r1 <= 3; r1++) {
            for (int r2 = 0; r2 <= r1; r2++) {
                for (int r3 = 0; r3 <= r2; r3++) {
                    System.out.println("(" + r1 + "," + r2 + "," + r3 + ")");
                }
            }
        }
    }
}