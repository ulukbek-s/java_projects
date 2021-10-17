import processing.core.PApplet;

import javax.swing.*;

public class Main extends PApplet {

    static int n, m;

    float[][] x, y, dx, dy;
    float[] rx, ry;
    float r, c;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        noStroke();
        rx = new float[n];
        ry = new float[n];
        x = new float[n][m];
        y = new float[n][m];
        dx = new float[n][m];
        dy = new float[n][m];
        r = 30;
        c = 255.f / m;
        for (int i = 0; i < n; i++) {
            x[i][0] = (int) random(40, width - 40);
            y[i][0] = (int) random(40, height - 40);
            dx[i][0] = (int) (random(-1, 1) < 0 ? random(-4, -1) : random(1, 4));
            dy[i][0] = (int) (random(-1, 1) < 0 ? random(-4, -1) : random(1, 4));
            int t = (int) ((r) / sqrt(sq(dx[i][0]) + sq(dy[i][0])));
            rx[i] = dx[i][0] * t;
            ry[i] = dy[i][0] * t;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {

                x[i][j] = x[i][j - 1] - rx[i];
                y[i][j] = y[i][j - 1] - ry[i];
                dx[i][j] = dx[i][j - 1];
                dy[i][j] = dy[i][j - 1];

                if (x[i][j] < 0) {
                    rx[i] = -rx[i];
                    dx[i][j] = -dx[i][j];
                    x[i][j] = -x[i][j];
                } else if (x[i][j] > width) {
                         rx[i] = -rx[i];
                    dx[i][j] = -dx[i][j];
                    x[i][j] = 2 * width - x[i][j];
                }

                if (y[i][j] < 0) {
                    ry[i] = -ry[i];
                    dy[i][j] = -dy[i][j];
                    y[i][j] = -y[i][j];
                } else if (y[i][j] > height) {
                    ry[i] = -ry[i];
                    dy[i][j] = -dy[i][j];
                    y[i][j] = 2 * height - y[i][j];
                }


            }
        }
    }

    public void draw() {
        background(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 3 == 0) fill(0, 0, 255 - c * j);
                else if (i % 3 == 1) fill(0, 255 - c * j, 0);
                else fill(255 - c * j, 0, 0);

                ellipse(x[i][j], y[i][j], r, r);

                x[i][j] += dx[i][j];
                y[i][j] += dy[i][j];

                if (x[i][j] < 0 || x[i][j] > width) dx[i][j] *= -1;
                if (y[i][j] < 0 || y[i][j] > height) dy[i][j] *= -1;
            }
        }
    }

    public static void main(String... args) {
        n = Integer.parseInt(JOptionPane.showInputDialog("Number of lines: "));
        m = Integer.parseInt(JOptionPane.showInputDialog("Length: "));
        PApplet.main("Main");
    }
}