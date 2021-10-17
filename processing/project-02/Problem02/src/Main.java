import processing.core.*;
import javax.swing.*;

public class Main extends PApplet {
    final float MIN_RADIUS = 10;
    final float MAX_RADIUS = 30;
    final float MIN_SPEED = 1;

    int n;
    float[] r;
    float[] x;
    float[] dx;
    float[] y;
    float[] dy;
    float[] a;
    float[] da;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog("Number of stars"));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Incorrect Integer");
            System.exit(1);
        }

        if (n < 0 || 1000 < n){
            JOptionPane.showMessageDialog(null, "Incorrect Integer");
        }

        r = new float[n];
        x = new float[n];
        dx = new float[n];
        y = new float[n];
        dy = new float[n];
        a = new float[n];
        da = new float[n];

        for (int i = 0; i < n; i++) {
            r[i] = random(MIN_RADIUS, MAX_RADIUS);
            x[i] = random(width);
            y[i] = random(height) + r[i];
            dx[i] = random(MIN_SPEED, r[i] / 5);
            dy[i] = random(MIN_SPEED, r[i] / 5);
            da[i] = random(0.05f, 0.1f);
        }

        strokeWeight(2);
    }

    public void draw() {
        background(0, 0, 0);
        int colorCh = 255;
        for (int i = 0; i < n; i++) {
            stroke(colorCh, colorCh, colorCh);
            if (r[i] <= 15 && colorCh >= 125) {
                colorCh -= 20;
            }
            drawStar(x[i], y[i], r[i], a[i]);

            if (x[i] + r[i] >= width - 1) {
                dx[i] = -dx[i];
                da[i] = -da[i];
            }
            if (x[i] - r[i] <= -1) {
                dx[i] = -dx[i];
                da[i] = -da[i];
            }

            if (y[i] > height + r[i]) {
                y[i] = 0 - r[i];
            }
            y[i] += 1;
            a[i] += da[i];
        }
    }

    void drawStar(float x, float y, float r, float a) {
        pushMatrix();
        translate(x, y);
        rotate(a);
        for (int i =0; i <= 5; i++){
            if (i % 2 == 0) {
                line(0, -r, 0, r);
            } else {
                line(0, -r / 2, 0, r / 2);
            }
            rotate(2 * PI / 10);
        }
        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

}