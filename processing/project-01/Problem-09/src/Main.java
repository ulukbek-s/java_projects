import processing.core.*;
import javax.swing.*;
import java.awt.*;

public class Main extends PApplet {
    float alpha;
    float rotation;
    float dx;
    float dy;

    float x;
    float y;
    float a;
    float dbetween;
    int number;

    public void settings() {
        size(1000, 600);
    }

    public void setup() {
        x = width / 2;
        y = height / 2;
        rectMode(CENTER);
        alpha = 0;
        rotation = 0.1f;
        dy = dx = 2;
        a = 50;
        dbetween = a/2;
        number = 4;
        frameRate(100);

    }

    public void draw() {
        fill(0, 70);
        noStroke();
        rect(x, y, width, height);
        for(int i = 0; i < number; i++) {
            for(int j =  0; j < number; j++) {
                drawRotatingSquare(alpha, x - (a + dbetween) * 2 + i* (a + dbetween),
                        y - (a  + dbetween) * 2 + j * (a  + dbetween), a, a);
            }
        }
        dx = checkOverflowX(x, dx);
        dy = checkOverflowY(y, dy);

        alpha += rotation;
        x += dx;
        y += dy;
    }
    void drawRotatingSquare(float a1, float x, float y, float a, float b) {
        pushMatrix();
        translate(x, y);
        fill(255);
        rotate(a1);
        rect(0, 0, a, b);
        popMatrix();

    }

    float checkOverflowX(float x, float dx) {

        if (x > width -(a + dbetween) * (number - 3) - 50) {
            dx = -dx;
        }
        if (x <(a  + dbetween) * 2 + 50) {
            dx = -dx;
        }
        return dx;
    }

    float checkOverflowY(float y, float dy) {
        if( y > height - (a + dbetween) * (number - 3) - 50) {
            dy = -dy;
        }
        if( y < (a + dbetween)*2 + 50) {
            dy = -dy;
        }
        return dy;
    }


    public static void main(String[] args) {
        PApplet.main("Main");
    }

}
