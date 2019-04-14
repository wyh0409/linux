import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;

public class ShowLife extends Applet
{
    String s;
    int inits = 0, starts = 0, stops = 0;
    public void init()
    {
        inits++;
        System.out.println("now init");
        System.out.println("leave init");
    }

    public void start ()
    {
        starts++;
        System.out.println("now stop");
        System.out.println("leave start");
    }

    public void stop()
    {
        stops++;
        System.out.println("now stop");
        System.out.println("leave stop");
    }
    public void paint(Graphics g)
    {
        s = "inits:"+inits+", starts:"+starts+", stops:"+stops;
        g.drawString(s,10,10);
        System.out.println("now paint:"+s);
    }
}
