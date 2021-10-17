import processing.core.*;

import javax.swing.*;

public class Main extends PApplet {
    float D;
    float x;
    float y;
    float dx;
    float dy;
    int i;
    float hfField;
    float sizeCircle;
    float maxW;
    float maxH;
    float minW;
    float minH;
    float field;
    float lineW;
    float lineH;
    float lineW2;
    float lineH2;
    String direction;
    public void settings() {

        fullScreen();
    }

    public void setup() {
        String strDiameter = JOptionPane.showInputDialog("Enther the field's size[10,40]");
                try{
                    D = parseInt(strDiameter);
                    if(D < 10 || D > 40)
                        throw new NumberFormatException();
                }catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect input" + strDiameter);
                    System.exit(1);
                }
        field = 700;
        sizeCircle = field / D;
        hfField = field / 2;
        lineW = hfField;
        lineH = hfField;
        lineW2 = hfField;
        lineH2 = hfField;
        dx = 0;
        dy = 0;
        i = 0;
        maxW = width / 2f + hfField;
        maxH = height / 2f + hfField;
        minW = width / 2f - hfField;
        minH = height / 2f - hfField;
        direction = "";
        frameRate(20);


    }

    public void draw() {
        fill(0,0,0,70);
        rect(0,0,width - 1, height - 1);
        stroke(0,0,255);
        while(i <= D)
        {
            line(width / 2f - lineW, height / 2f - lineH, width / 2f + lineW, height / 2f - lineH);
            lineH -= field / D;
            line(width / 2f - lineW2, height / 2f - lineH2, width / 2f - lineW2, height / 2f + lineH2);
            lineW2 -= field / D;
            i ++;
        }
        lineH = hfField;
        lineW2 = hfField;
        i = 0;
        if(direction.equals(""))
        {
            textSize(20);
            textAlign(CENTER);
            fill(255,0,0);
            text("Press arrow button",width / 2f, 20);
            }
        else
        {
            textSize(20);
            textAlign(CENTER);
            fill(255,0,0);
            text("You pressed button" + direction, width / 2f, 20);

        }
        if(x > maxW - sizeCircle / 2f)
        {
            dx = 0;
            dy = 0;
            x = maxW - sizeCircle / 2f;

        }
        else if(x < minW + sizeCircle / 2f)
        {
            dx = 0;
            dy = 0;
            x = minW + sizeCircle / 2f;
        }
        else if(y < minH + sizeCircle / 2f)
        {
            dx = 0;
            dy = 0;
            y = minH + sizeCircle / 2f;
        }
        else if(y > maxH - sizeCircle / 2f)
        {
            dx = 0;
            dy = 0;
            y = maxH - sizeCircle / 2f;
        }
        noStroke();
        fill(255,0,0);
        circle(x,y,sizeCircle);
        x += dx;
        y += dy;
        if (key == CODED) {
            if (keyCode == UP) {
                direction = "UP";
                dx = 0;
                dy = -sizeCircle;
            } else if (keyCode == RIGHT) {
                direction = "Right";
                dx = sizeCircle;
                dy = 0;
            }  else if (keyCode == LEFT) {
                direction = "LEFT";
                dx = -sizeCircle;
                dy = 0;
            } else if (keyCode == DOWN) {
                direction = "DOWN";
                dx = 0;
                dy = sizeCircle;
            }
        }

    }




    public static void main(String[] args) {
        PApplet.main("Main");
    }

}