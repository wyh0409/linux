import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Timer;
import java.applet.*;

public class TimerTest extends Applet
{
    static Olimpic mt = new Olimpic("Olimpic",50, 50, 420, 320);
    public void init()
    {
        int ch;
        mt.setVisible(true);
        Timer timer = new Timer();

        timer.schedule(new MyTask(), 1000, 2000);
        while (true) {
            try {
                ch = System.in.read();
                if (ch-'c' == 0) {
                    timer.cancel();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyTask extends java.util.TimerTask
    {
        public void run()
        {
            mt.repaint();
        }
    }
}

class Olimpic extends Frame
{
    static int count = 0;
    Color c0 = new Color(128, 200, 238);
    Color c1 = new Color(57, 60, 69);
    Color c2 = new Color(220, 44, 31);
    Color c3 = new Color(242, 176, 54);
    Color c4 = new Color(52, 162, 67);

    public Olimpic(String title, int x, int y, int width, int height) 
    {
        setBounds(x, y, width, height);
        setTitle(title);
        addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) 
    {
        count = count%5;
        System.out.print(count);

        switch (count) {
            case 0:
                g.setColor(c0);
                g.drawOval(50, 50, 100, 100);
                break;
            
            case 1:
                g.setColor(c0);
                g.drawOval(50, 50, 100, 100);
                g.setColor(c1);
                g.drawOval(160, 50, 100, 100);
                break;

            case 2:
                g.setColor(c0);
                g.drawOval(50, 50, 100, 100);
                g.setColor(c1);
                g.drawOval(160, 50, 100, 100);
                g.setColor(c2);
                g.drawOval(270, 50, 100, 100);
                break;

            case 3:
                g.setColor(c0);
                g.drawOval(50, 50, 100, 100);
                g.setColor(c1);
                g.drawOval(160, 50, 100, 100);
                g.setColor(c2);
                g.drawOval(270, 50, 100, 100);
                g.setColor(c3);
                g.drawOval(105, 100, 100, 100);
                break;

            case 4:
                g.setColor(c0);
                g.drawOval(50, 50, 100, 100);
                g.setColor(c1);
                g.drawOval(160, 50, 100, 100);
                g.setColor(c2);
                g.drawOval(270, 50, 100, 100);
                g.setColor(c3);
                g.drawOval(105, 100, 100, 100);
                g.setColor(c4);
                g.drawOval(220, 100, 100, 100);
                break;

            default:
                
                break;
        }
        count++;
    }
}