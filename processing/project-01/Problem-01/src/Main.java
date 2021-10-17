import processing.core.*;

public class Main extends PApplet {
    float x;
    float dx;
    float dx1;
    float y;
    float x1;
    float x2;
    float y2;
    float y1;
    float dy;
    float dy1;
    float dx2;
    float dy2;


    public void settings() {
        fullScreen();
    }

    public void setup() {
        noStroke();
        x = width / 2f;
        dx = 10;

        y = height / 2f;
        dy = 10;


        x1 = x - 50;
        dx1 = 10;

        y1 = y - 50;
        dy1 = 10;


        x2 = x1 - 50;
        dx2 = 10;

        y2 = y1 - 50;
        dy2 = 10;


    }

    public void draw() {
        background(0, 0, 0);


        //first
        fill(255, 0, 0);
        ellipse(x, y, 50, 50);
        fill(0, 255, 0);
        ellipse(x1, y1, 50, 50);
        fill(0, 0, 255);
        ellipse(x2, y2, 50, 50);
        x += dx;
        y += dy;
        x1 += dx1;
        y1 += dy1;
        x2 += dx2;
        y2 += dy2;
        if (x >= width) {
            dx = -dx;
            x = width - 1;
        }
        if (x < 0) {
            dx = -dx;
            x = 0;
        }


        if (y >= height) {
            dy = -dy;
            y = height - 1;
        }
        if (y < 0) {
            dy = -dy;
            y = 0;


        }
        //second
        if (x1 >= width) {
            dx1 = -dx1;
            x1 = width - 1;
        }
        if (x1 < 0) {
            dx1 = -dx1;
            x1 = 0;
        }


        if (y1 >= height) {
            dy1 = -dy1;
            y1 = height - 1;
        }
        if (y1 < 0) {
            dy1 = -dy1;
            y1 = 0;
        }

        //third


        if (x2 >= width) {
            dx2 = -dx2;
            x2 = width - 1;
        }
        if (x2 < 0) {
            dx2 = -dx2;
            x2 = 0;
        }


        if (y2 >= height) {
            dy2 = -dy2;
            y2 = height - 1;
        }
        if (y2 < 0) {
            dy2 = -dy2;
            y2 = 0;
        }


    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

}