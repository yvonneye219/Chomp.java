import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;



    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int rows = gameBoard.length;
        int cols = gameBoard[0].length;

        for (int c = 0; c < cols; c++) {
            int count = 0;

            for (int r = 0; r < rows; r++) {
                if (gameBoard[r][c] != null) {
                    count++;
                }
            }

            columns[c] = count;
        }

        int row = 1;
        int column = 1;


        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

}
