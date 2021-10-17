import processing.core.*;


public class Main extends PApplet {
    int boxSize = 15;
    int sideLength = 30;
    int cells_Left;
    int flags_Left;

    boolean dead = false;
    boolean deadNextFrame = true;
    boolean won = false;
    boolean wonNextFrame = false;

    mineField field;

    public void settings() {
        size(boxSize * sideLength, boxSize * sideLength + 30);
    }

    public void setup() {
        field = new mineField();

    }
/// 11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
    public void draw() {
        flags_Left = sideLength * 4;
        cells_Left = sideLength * sideLength;

        if(!dead && !won) {
            for (int i = 0; i < sideLength; i++) {
                for (int j = 0; j < sideLength; j++) {
                    // when the block open
                    if (field.untruned[i][j] == 1) {
                        cells_Left--;
                        // check if it is a mine
                        if (field.fieldMat[i][j] == -1) {

                            fill(0);
                            square(i * boxSize, j * boxSize, boxSize);
                        }
                        // otherwise count the bombs around
                        else {
                            fill(255);
                            square(i * boxSize, j * boxSize, boxSize);
                            textSize(15);
                            fill(0);
                            text(field.bombsAroundMe(i, j), i * boxSize + boxSize / 3f, j * boxSize + boxSize, boxSize);
                        }
                    }
                    // when it is closed and when we put a flag fill it with a red
                    else if (field.untruned[i][j] == 2) {
                        fill(255, 0, 0);
                        square(i * boxSize, j * boxSize, boxSize);
                        cells_Left--;
                        flags_Left--;
                    } else
                    // whet we close it by default
                    {
                        fill(118);
                        square(i * boxSize, j * boxSize, boxSize);
                    }
                }
            }
            fill(0);
            textSize(15);
            text("Cells left: " + cells_Left, 5, boxSize * sideLength + 20);
            text("Flags left: " + flags_Left, width - (85 + str(flags_Left).length() * 10), boxSize * sideLength + 20);
            if (cells_Left == 0) {
                won = true;
            }
        }
            else if(won && !wonNextFrame)
            {
                for (int i = 0; i < sideLength; i++) {
                    for (int j = 0; j < sideLength; j++) {
                        // when the block open
                        if (field.untruned[i][j] == 1) {
                            cells_Left--;
                            // check if it is a mine
                            if (field.fieldMat[i][j] == -1) {

                                fill(0);
                                square(i * boxSize, j * boxSize, boxSize);
                            }
                            // otherwise count the bombs around
                            else {
                                fill(255);
                                square(i * boxSize, j * boxSize, boxSize);
                                textSize(15);
                                fill(0);
                                text(field.bombsAroundMe(i, j), i * boxSize + boxSize / 3f, j * boxSize + boxSize, boxSize);
                            }
                        }
                        // when it is closed and when we put a flag fill it with a red
                        else if (field.untruned[i][j] == 2) {
                            fill(255, 0, 0);
                            square(i * boxSize, j * boxSize, boxSize);
                            cells_Left--;
                            flags_Left--;
                        } else
                        // whet we close it by default
                        {
                            fill(118);
                            square(i * boxSize, j * boxSize, boxSize);
                        }
                    }
                }
                fill(0);
                textSize(15);
                text("You won ", width / 2f - 40, boxSize * sideLength + 20);
                wonNextFrame = true;
            }
            else if(dead) {
                if (deadNextFrame) {
                    for (int i = 0; i < sideLength; i++) {
                        for (int j = 0; j < sideLength; j++) {
                            // when the block open
                            if (field.untruned[i][j] == 1) {
                                // check if it is a mine
                                cells_Left--;
                                if (field.fieldMat[i][j] == -1) {

                                    fill(0);
                                    square(i * boxSize, j * boxSize, boxSize);
                                }
                                // otherwise count the bombs around
                                else {
                                    fill(255);
                                    square(i * boxSize, j * boxSize, boxSize);
                                    textSize(15);
                                    fill(0);
                                    text(field.bombsAroundMe(i, j), i * boxSize + boxSize / 3f, j * boxSize + boxSize, boxSize);
                                }
                            }
                            // when it is closed and when we put a flag fill it with a red
                            else if (field.untruned[i][j] == 2) {
                                fill(255, 0, 0);
                                square(i * boxSize, j * boxSize, boxSize);
                                cells_Left--;
                                flags_Left--;
                            } else
                            // whet we close it by default
                            {
                                fill(118);
                                square(i * boxSize, j * boxSize, boxSize);
                            }
                        }
                    }
                    fill(0);
                    textSize(15);
                    text("You lost!", width / 2f - 40, boxSize * sideLength + 20);
                }
                deadNextFrame = false;
            }
        }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
/// 2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
    public void mousePressed() {

        int x = mouseX / boxSize;
        int y = mouseY / boxSize;

        if (mouseButton == LEFT)
        {
            // it prevents from pressing a flag
            if (field.untruned[x][y] != 2)
            {
                // check if the bomb is in current place
                if (field.fieldMat[x][y] == -1)
                {
                    // open all the bombs
                    dead = true;
                    for (int i = 0; i < sideLength; i++)
                    {
                        for (int j = 0; j < sideLength; j++)
                        {
                            if (field.fieldMat[i][j] == -1)
                            {
                                field.untruned[i][j] = 1;
                            }
                        }
                    }
                }
            }
            revealBlocks(x, y);
        }
        if (mouseButton == RIGHT) {
            if (field.untruned[x][y] != 1) {
                if (field.untruned[x][y] == 2) {
                    field.untruned[x][y] = 0;
                } else {
                    field.untruned[x][y] = 2;
                }

            }

        }


    }
/// 333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
    void revealBlocks(int x, int y) {
        if (field.bombsAroundMe(x, y) == 0)
        {
            if (field.untruned[x][y] != 1)
            {
                if (x == 0 && y == 0)
                {
                    for (int i = x; i <= x + 1; i++)
                    {
                        for (int j = y; j <= y + 1; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                } else if (x == 0 && y == sideLength - 1)
                {
                    for (int i = x; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y; j++) {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                } else if (x == sideLength - 1 && y == 0)
                {
                    for (int i = x - 1; i <= x; i++)
                    {
                        for (int j = y; j <= y + 1; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                } else if (x == 0)
                {
                    for (int i = x; i <= x + 1; i++)
                    {
                        for (int j = y - 1; j <= y + 1; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                } else if (y == 0) {
                    for (int i = x - 1; i <= x + 1; i++)
                    {
                        for (int j = y; j <= y + 1; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                } else if (x == sideLength - 1)
                {
                    for (int i = x - 1; i <= x; i++)
                    {
                        for (int j = y - 1; j <= y + 1; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                } else if (y == sideLength - 1)
                {
                    for (int i = x - 1; i <= x + 1; i++)
                    {
                        for (int j = y - 1; j <= y; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }
                }
                else{
                    for (int i = x - 1; i <= x + 1; i++)
                    {
                        for (int j = y - 1; j <= y + 1; j++)
                        {
                            if (!(i == x && j == y) && field.fieldMat[i][j] != -1)
                            {
                                field.untruned[x][y] = 1;
                                revealBlocks(i, j);
                            }
                        }
                    }

                }


            }

        }
        else
        {
            field.untruned[x][y] = 1;
        }

    }

}