import processing.core.PApplet;
import javax.swing.*;

public class Main extends PApplet {
    final int r = 30;
    float x = 500;
    float y = 500;
    int n = Integer.parseInt(JOptionPane.showInputDialog("Number of segments of the snake:"));
    float[] x1 = new float[n];
    float[] y1 = new float[n];
    float[] dx = new float[n];
    float[] dy = new float[n];
    int[] tp = new int[n];

    public void settings(){
        size(1024,600);


        }

    public void setup() {
        background(0);
        int mx_tp = 255;
        for (int i = 0; i < n; i++) {
            x1[i] = x;
            y1[i] = y;
            x = x - cos(PI / 4) * r;
            y = y - sin(PI / 4) * r;
            dx[i] = 2;
            dy[i] = 2;
            tp[i] = mx_tp;
            mx_tp -= 10;

        }
    }
    public void draw(){
        background(0);
        for(int i = 0 ; i< n; i ++)
        {
            pushMatrix();
            translate(x1[i],y1[i]);
            noStroke();
            fill(255,0,255,tp[i]);
            circle(0,0,r);
            popMatrix();
            x1[i] += dx[i];
            y1[i] += dy[i];
            if(x1[i] + r / 2f > width || x1[i] - r / 2f < 0)
                dx[i] = -dx[i];
            if(y1[i] + r / 2f > height || y1[i] - r / 2f < 0)
                dy[i] = -dy[i];
        }

    }
    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
