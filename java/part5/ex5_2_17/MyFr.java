import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyFr extends Applet 
{
    MyFrame f = new MyFrame("my first frame");
    Button b1 = new Button("open");
    Button b2 = new Button("close");

    public void init()
    {
        add(b1);
        add(b2);
        b1.addActionListener(new B1L());
        b2.addActionListener(new B2L());
        f.setSize(200,300);
    }

    class B1L implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(true);
        }
    }

    class B2L implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(false);
        }
    }

    class MyFrame extends Frame
    {
        Label la1 = new Label("My Applet Frame");

        MyFrame(String s) {
            super(s);
            add(la1);
        }
    }
}