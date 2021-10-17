import processing.core.*;
import javax.swing.*;

public class Main extends PApplet {
    final float MIN_RADIUS = 5;
    final float MAX_RADIUS = 50;
    final float MIN_SPEED = 1f;

    int n;
    float[] r;
    float[] x;
    float[] dx;
    float[] y;
    float[] dy;
    float[] rc;
    float[] gc;
    float[] bc;
    float[] a;
    float[] da;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog("Number of stars:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Incorrect int ");
        }
        if (n < 0 || n > 1000) {
            JOptionPane.showMessageDialog(null, "Incorrect int");
        }
        r = new float[n];
        x = new float[n];
        dx = new float[n];
        y = new float[n];
        dy = new float[n];
        rc = new float[n];
        gc = new float[n];
        bc = new float[n];
        a = new float[n];
        da = new float[n];



        for (int i = 0; i < n; i++) {
            r[i] = random(MIN_RADIUS, MAX_RADIUS);
            x[i] = random(width);
            y[i] = random(height);
            dx[i] = random(MIN_SPEED, r[i] / 4);
            dy[i] = random(MIN_SPEED, r[i] / 4);
            if (random(2) < 1) {
                dx[i] = -dx[i];
            }
            if (random (2) < 1){
                dy[i] = -dy[i];
            }
            rc[i]= random(255);
            gc[i]= random(255);
            bc[i]= random(255);
            da[i]= random(0.05f,0.01f);
        }

    }

    public void draw() {
        background(0, 0, 0);
        for (int i = 0; i < n; i++) {
            stroke(rc[i], gc[i], bc[i]);
            drawStar(x[i], y[i], r[i], a[i]);
            if (x[i] >= width - r[i]) {
                dx[i] = -dx[i];
                x[i] = width - r[i];
            }
            if (x[i] <= 0 + r[i]) {
                dx[i] = -dx[i];
                x[i] = r[i];
            }
            if (y[i] >= height - r[i]) {
                dy[i] = -dy[i];
                y[i] = height - r[i];
            }
            if (y[i] <= 0 + r[i]) {
                dy[i] = -dy[i];
                y[i] = r[i];
            }
            x[i] += dx[i];
            y[i] += dy[i];
            a[i]+=da[i];

        }
        strokeWeight(3);
    }

    void drawStar(float x, float y, float r,float a){
        pushMatrix();
        translate(x, y);
        rotate(a);
        for(int i = 0; i <= 5; i++){
            line(0, -r,0, r);
            rotate(2 * PI/10);
        }
        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

}