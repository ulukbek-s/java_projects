import processing.core.*;
import javax.swing.*;
import java.awt.*;

public class Main extends PApplet {

    PFont font;
    int xText1 = 850;
    int yText1 = 350;
    int xText2 = 850;
    int yText2 = 700;
    int direction1 = 10;
    int direction2 = 10;
    String text1 = JOptionPane.showInputDialog( "First message");
    String text2 = JOptionPane.showInputDialog("Second message");

    public void settings() {
        size(1920, 1080);
    }

    public void setup() {
        background(0);
        font = createFont("Arial", 80, true);
    }

    public void draw() {

        background(0);
        textFont(font);

        fill(225, 0, 0);
        text(text1, xText1, yText1);
        fill(0, 225, 0);
        text(text2, xText2, yText2);

        xText1 += direction1;
        xText2 -= direction2;

        if (xText1 + 200 > width) {
            direction1 = -10;
        }

        if (xText2 + 250 > width) {
            direction2 = 10;
        }

        if (xText1 < 0) {
            direction1 = 10;
        }

        if (xText2 < 0) {
            direction2 = -10;
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}