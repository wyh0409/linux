import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;

class DrawLine extends JPanel
{
    private int startX;
    private int startY;
    private int length;
    public DrawLine(int x, int y, int le) 
    {
        this.setBackground(Color.lightGray);
        this.setForeground(Color.blue);
        startX = x;
        startY = y;
        length = le;    
    }

    public void setLength(int la) 
    {
        length = la;
        repaint();    
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawString("try to draw line", 10, 10);
        g.setColor(Color.red);
        g.drawLine(startX, startY, startY+length, startY);    
    }
}

public class JPaint2 extends JApplet
{
    private DrawLine drawline1 = new DrawLine(30, 20, 30);
    private JSlider adjustCycles = new JSlider(1, 100, 5);

    public void init() 
    {
        Container cp = this.getContentPane();
        cp.add(drawline1);
        adjustCycles.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) 
            {
                drawline1.setLength(((JSlider)e.getSource()).getValue());   
            }
        });


        cp.add(BorderLayout.SOUTH, adjustCycles);

    }
}