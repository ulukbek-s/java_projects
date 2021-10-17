import processing.core.*;

public class Main extends PApplet {
    final int n = 100;
    float[] x = new float[n];
    float[] y = new float[n];
    float[] r = new float[n];
    float[] a = new float[n];
    float[] da = new float[n];

    public void settings() {
        fullScreen();
    }

    public void setup() {
        for(int i = 0; i < n; i ++)
        {
            x[i] = random(width);
            y[i] = random(height);
            r[i] = random(20,60);
            a[i] = random(PI * 2);
            da[i] = random(-0.05f,0.05f);
        }




    }


    public void draw() {
        fill(0,0,0,50);
        rect(0, 0, width - 1, height - 1);
        strokeWeight(4);
        for(int i = 0; i < n; i ++)
        {
            drawStar(x[i],y[i],r[i],a[i],50,50,50);
            x[i] += random(-r[i] / 20, r[i] / 20);
            y[i] += r[i] / 10 ;
            if(y[i] > height)
            {
                x[i] = random(width);
                y[i] = -r[i];
            }
            a[i] += da[i];
        }


    }
    private void drawStar (float x, float y, float r, float a, float rc, float gc, float bc)
    {
        pushMatrix();
        translate(x,y);
        rotate(a);
        stroke(rc,gc,bc);
        line(-r, 0, r, 0);
        line(0,-r,0, r);
        line(-r / 4f, -r / 4f, r / 4f, r / 4f);
        line(-r / 4f, r / 4f, r / 4f, -r / 4f);
        popMatrix();
    }


    public static void main(String[] args) {
        PApplet.main("Main");
    }

}