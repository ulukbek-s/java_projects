import processing.core.*;

import javax.swing.*;

public class Main extends PApplet {

    final float SIZE = 50;
    float column, row;

    public void settings(){
        fullScreen();
    }

    public void setup(){
        background(160, 238, 242);

        column = Integer.parseInt(JOptionPane.showInputDialog("Enter the column between(0:20)"));
        row = Integer.parseInt(JOptionPane.showInputDialog("Enter the row between(0:20)"));

        while (!(column > 0 && column < 20 && row > 0 && row < 20)){
            JOptionPane.showMessageDialog(frame, "Invalid Value, Please Try Again");
            column = Integer.parseInt(JOptionPane.showInputDialog("Enter the column between(0:20)"));
            row = Integer.parseInt(JOptionPane.showInputDialog("Enter the row between(0:20)"));
        }

    }

    public void draw(){
        background(100, 100, 100);

        float fieldWidth = column * SIZE;
        float fieldHeight = row * SIZE;
        float centeringShiftX = (width - fieldWidth) / 2f;
        float centeringShiftY = (height - fieldHeight) / 2f;

        for (int x = 0; x < row; x++){
            for (int y = 0; y < column; y++){
                float pixelX = centeringShiftX + x * SIZE;
                float pixelY = centeringShiftY + y * SIZE;
                fill(((x + y) % 2 == 0 ? 0 : 255));
                square(pixelX, pixelY, SIZE);
            }
        }

        if (mouseX > centeringShiftX && mouseX < centeringShiftX + fieldWidth &&
                mouseY > centeringShiftY && mouseY < centeringShiftY + fieldHeight){

            int columnNumber = ((int)(mouseX - centeringShiftX) / (int) SIZE);
            int rowNumber = ((int)(mouseY - centeringShiftY) / (int) SIZE);

            String mouseText = String.format("Row: %d, Column: %d, Color: %s", rowNumber + 1,
                    columnNumber + 1, fill(rowNumber, columnNumber));

            float pixelX = centeringShiftX + columnNumber * SIZE;
            float pixelY = centeringShiftY + rowNumber * SIZE;

            strokeWeight(5);
            stroke(255, 0, 0);
            fill(20,0,0,0);
            square(pixelX, pixelY, SIZE);

            float mouseCoordinateX = width / 2f;
            float mouseCoordinateY = centeringShiftY - 30;

            noStroke();
            textSize(30);
            textAlign(CENTER, CENTER);
            fill(0);
            text(mouseText, mouseCoordinateX, mouseCoordinateY);
        }
    }

    public String fill(int rowNumber, int columnNumber){

        return ((rowNumber + columnNumber) % 2 == 0) ? "Black" : "White";
    }

    public static void main(String[] args) {

        PApplet.main("Main");
    }
}
