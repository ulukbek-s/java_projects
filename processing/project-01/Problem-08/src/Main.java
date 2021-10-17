import processing.core.*;
import javax.swing.*;
import java.awt.*;

public class Main extends PApplet {
    float startAngle = 0.0f;
    float plusAngle = 0.06f;
    float starAng = 0.0f;

    float x;
    float y;

    int stars = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of stars (5, 12): "));

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(0);

        x = width * 0.5f;
        y = height * 0.5f;
    }

    public void draw() {
        background(0);

        stroke(255, 0, 0);
        star(8, x, y, 70.0f, 200.0f, startAngle);
        startAngle += plusAngle;

        float step = TWO_PI / stars;
        for (int i = 0; i < stars; i++) {
            float X = x + cos(starAng) * 350f;
            float Y = y + sin(starAng) * 350f;

            stroke(255,255,0);
            star(8, X, Y, 35f, 100f, startAngle);

            starAng += step;
        }
    }




    void star(int rayCount, float x, float y, float radius1, float radius2, float angle) {
        float angleStep = TWO_PI / 8;

        float prevEndX = x + cos(angle - angleStep) * radius1;
        float prevEndY = y + sin(angle - angleStep) * radius1;
        for (int i = 0; i < 8; i++) {
            float selectedRadius = i % 2 == 0 ? radius2 : radius1;
            float endX = x + cos(angle) * selectedRadius;
            float endY = y + sin(angle) * selectedRadius;
            line(x, y, endX, endY);
            line(prevEndX, prevEndY, endX, endY);

            angle += angleStep;
            prevEndX = endX;
            prevEndY = endY;
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}