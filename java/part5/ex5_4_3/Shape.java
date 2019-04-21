import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Shape extends Applet 
{
    int polyx[] = {10, 30, 50, 50, 30, 10};
    int polyy[] = {30, 50, 30, 60, 55, 70};
    
    public void init() 
    {
        resize(500,500);    
    }

    public void paint(Graphics g) 
    {
        g.drawRect(10, 10, 20, 20);
        g.setColor(Color.blue);
        g.fillRect(10, 10, 20, 20);
        
        g.setColor(Color.black);
        g.fill3DRect(70, 10, 20, 20, true);
        g.fill3DRect(100, 10,20, 20, false);

        g.setColor(Color.red);
        g.drawOval(130, 10, 30, 20);
        g.drawArc(170, 10, 20, 20, 0, 90);
        g.fillArc(200,10,20,20,0,180);

        g.drawPolygon(polyx, polyy, 6);
    }
}