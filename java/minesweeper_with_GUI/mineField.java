import processing.core.PApplet;

public class mineField extends PApplet {
    int sideLength = 30;
    int fieldMat[][] = new int[sideLength][sideLength];
    int untruned[][] = new int[sideLength][sideLength];
    int bombsNumAroundMe;

    mineField(){
        for(int i = 0; i < sideLength * 4; i ++)
        {
            int col = floor(random(sideLength));
            int row = floor(random(sideLength));
            // check if the location is not repeated
            while (fieldMat[row][col] == -1)
            {
                col = floor(random(sideLength));
                row = floor(random(sideLength));
            }
            // mark location
            fieldMat[row][col] = -1;
        }
    }



    int bombsAroundMe(int row, int col){
        bombsNumAroundMe = 0;
        try{
            if(fieldMat[row - 1][col - 1] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row + 1][col - 1] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row + 1][col + 1] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row - 1][col + 1] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row][col - 1] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row][col + 1] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row - 1][col] == -1){
                bombsNumAroundMe ++;
            }
            if(fieldMat[row + 1][col] == -1){
                bombsNumAroundMe ++;
            }
        } catch (Exception e) {
        }

        return bombsNumAroundMe;

    }
}

