import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Animl extends Applet implements Runnable {
    int frameNumber = -1;
    final int number = 10;
    Thread animthread;
    Image[] pic = new Image[number];
    Dimension bufDimension;
    Image bufImage;
    Graphics bufGraphics;

    public void init() {
        int i;
        for (i = 1; i <= number; i++) {
            pic[i-1] = getImage(getCodeBase(),"T"+i+".gif");
        }
    }

    public void start() {
        animthread = new Thread(this);
        animthread.start();
    }

    public void stop() {
        animthread = null;
        bufGraphics = null;
        bufImage = null;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (currentThread == animthread) {
            frameNumber++;
            repaint();
            try {
                animthread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        if ((bufGraphics == null) || (d.width != bufDimension.width) || (d.height != bufDimension.height)) {
            bufDimension = d;
            bufImage = createImage(d.width,d.height);
            bufGraphics = bufImage.getGraphics();
        }
        bufGraphics.setColor(getBackground());
        bufGraphics.fillRect(0,0,d.width,d.height);
        bufGraphics.drawImage(pic[frameNumber%10],10,10,this);
        g.drawImage(bufImage,10,10,this);
    }
}