import processing.core.*;

public class Main extends PApplet {
    float angle = PI / 4;
    float dAngle = 0.01f;
    float angle2 = PI;
    float dAangle2 = 0.06f;
    float angle3 = PI/5;
    float dAangle3 = 0.05f;


    public void settings() {
        fullScreen();
    }

    public void setup() {
        noStroke();
    }

    public void draw() {
        fill(0,0,0,80);
        rect(0,0,width - 1, height - 1);
        translate(width / 2f, height / 2f);
        fill(255,255,0);
        circle(0,0,155);
        pushMatrix();
        rotate(angle);
        fill(20,0,255);
        circle(width / 4f, 0, 50);
        angle += dAngle;
        translate(width / 4f, 0);
        rotate(angle2);
        fill(250);
        circle(width / 20f, 0, 20);
        angle2 += dAangle2;
        popMatrix();
        fill(0,250,250);
        rotate(angle3);
        circle(width / 9f, 0, 60);
        angle3 += dAangle3;


    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}