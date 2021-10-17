import processing.core.*;


public class Main extends PApplet {
    float size1 = 100;
    float size2 = 100;
    float size3 = 100;
    final float MAX_SZ = 150;
    final float MIN_SZ = 50;
    float change = 1;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;


    public void settings() {
        fullScreen();
    }


    public void setup() {
        noStroke();

        x1 = width / 2f;
        y1 = height * 0.25f;

        x2 = width / 2f;
        y2 = height * 0.5f;


        x3 = width / 2f;
        y3 = height * 0.75f;
    }

    public void draw() {
        background(0);

        textAlign(CENTER, TOP);
        textSize(size1);
        fill(255, 0, 0);
        text("Hello", x1, y1);
        size1 += change;
        if (size1 >= MAX_SZ || size1 <= MIN_SZ) {
            change = -change;
        }

        //second
        textAlign(CENTER, CENTER);
        fill(0, 255, 0);
        textSize(size2);
        text("Wonderful,", x2, y2);
        size2 -= change;
        if (size2 >= MAX_SZ || size2 <= MIN_SZ) {
            change = -change;
        }


        //third
        textAlign(CENTER, BOTTOM);
        fill(0, 0, 255);
        textSize(size3);
        text("World of Java!", x3, y3);
        size3 += change;
        if (size3 >= MAX_SZ || size3 <= MIN_SZ) {
            change = -change;
        }


    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

}