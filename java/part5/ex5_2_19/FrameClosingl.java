import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class FrameClosingl extends Applet 
{
    MyFrame fram = new MyFrame("frame closing");
    Button b1 = new Button("open");
    Button b2 = new Button("close");
    WL fwl = new WL();

    public void init() 
    {
        add(b1);
        add(b2);
        b1.addActionListener(new B1L());
        b2.addActionListener(new B2L());
        fram.setSize(200,300);
        fram.addWindowListener(fwl);
    }

    class B1L implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            fram.setVisible(true);
        }
    }

    class B2L implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            fram.setVisible(false);
        } 
    }

    class MyFrame extends Frame 
    {
        Label la1 = new Label("My Applet Frame");
        MyFrame(String s) 
        {
            super(s);
            add(la1);
        }
    }

    class WL extends WindowAdapter
    {
        public void windowClosing (WindowEvent e) 
        {
            fram.setVisible(false);
        }
    }
}