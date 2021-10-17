package console;

import static java.lang.Math.random;


public class Game {

    int height;
    int width;
    int mines;
    int [][] data;

    public Game(int height, int width, int mines) {
        if(height < 1 ) {
            throw new RuntimeException("Game: height is less than one: " + height);
        }
        if(width < 1 ) {
            throw new RuntimeException("Game: width is less than one: " + width);
        }
        if(mines < 1 || mines >= width * height ) {
            throw new RuntimeException("Game: mines is less than one: " + mines);
        }
        this.height = height;
        this.width = width;
        this.mines = mines;
        this.data = new int [height][width];
    }

    @Override
    public String toString() {
        String header = String.format("Minesweeper: height = %d, width = %d, mines = %d\n",height,width, mines);
        StringBuilder r = new StringBuilder(header);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                r.append(data[i][j]);
            }
            r.append("\n");
        }

        return r.toString();


    }
    public void setMines() {
        int mineCnt = 0;
        while (mineCnt < mines) {
            int row = 1 + (int) (random() * width);
            int col = 1 + (int) (random() * height);

            if (data[row][col] >= 0) {
                data[row][col] = 1;
                borders(row, col);
                mineCnt++;
            }
        }
    }
    public void borders(int row, int col) {
        data[row + 1][col + 1]++;
        data[row - 1][col - 1]++;
        data[row + 1][col - 1]++;
        data[row - 1][col + 1]++;
        data[row - 1][col]++;
        data[row + 1][col]++;
        data[row][col + 1]++;
        data[row][col - 1]++;
    }


    public void left(int row, int col) {
        if(row < 0 || height <= row ){
            throw new RuntimeException("Out of range: "  + row);
        }

    }
}
