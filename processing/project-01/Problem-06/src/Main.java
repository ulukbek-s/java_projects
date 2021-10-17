import processing.core.*;
import javax.swing.*;
import java.awt.*;

public class Main extends PApplet {
    public int x;
    public int y; // x and y are coordiantes of circle
    public int size; // size of circle
    int m;

    public int rec_x;
    public int rec_y; // coordinates of rectangle
    public int rec_size_x;
    public int rec_size_y; // sizes of rectangle

    String position = "";

    public void settings() {
        size(1080, 600);
    }

    public void setup() {
        rec_x = rec_y = 100;
        rec_size_x = 300;
        rec_size_y = 400;

        int rand = (int)random(2);

        x +=(rand) == 1 ? 250 : 830; // here I put circle randomly in left rectangle or right rectangle you can just put it in left one so just x = 250;  and delete int rand = ...;
        y = 300;
        size = 50;
    }
    public void status() {
        position = inside();
        textSize(20);
        fill(245, 245, 66);
        text("The center of the circle is " + position, 340 , 30);
    }

    public String inside() {
        if(y > 100 && y < 500 ) {
            if(x > 100 && x < 400)
                return "in the left rectangle";
            if(x > 680 && x < 980)
                return "in the right rectangle";
        }
        return "outside of both rectangles";
    }

    public void draw() {
        background(0);

        stroke(52, 70, 235);
        noFill();
        rect(rec_x, rec_y, rec_size_x, rec_size_y);

        stroke(52, 70, 235);
        noFill();
        rect(rec_x + 280 + rec_size_x, rec_y , rec_size_x, rec_size_y);

        if(mousePressed && (mouseX - x)*(mouseX - x) + (mouseY - y)*(mouseY - y) <= 625) {
            x = mouseX;
            y = mouseY;
        }

        fill(145, 189, 255);
        stroke(145, 189, 255);
        ellipse(x,y, size, size);

        status(); // I used method to display position of circle
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}