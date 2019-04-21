import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Dialog1 extends Applet
{
    MyFrame f = new MyFrame("hi");
    Button b1 = new Button("open");
    Button b2 = new Button("class");

    public void init()
    {
        add(b1);
        add(b2);
        b1.addActionListener(new B1L());
        b2.addActionListener(new B2l());
        f.setSize(200,300);
    }
    
    class B1L implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(true);
        }
    }
    class B2l implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            f.setVisible(false);
        }
    }

    class MyFrame extends Frame
    {
        Label la1 = new Label("My Applet Frame");
        Button ob = new Button("open dialog");
        BL bl1 = new BL();
        MyDialog md = new MyDialog(this,"my dialog",false);

        WL wl = new WL();

        MyFrame(String s)
        {
            super(s);
            add(la1);
            add(ob);
            ob.addActionListener(bl1);
            md.addWindowListener(wl);
        }

        class BL implements ActionListener 
        {
            public void actionPerformed(ActionEvent e)
            {
                md.setVisible(true);
            }
        }
        class MyDialog extends Dialog 
        {
            MyDialog(Frame host, String title, boolean model) {
                super(host, title, model);
                setSize(100,100);
            }
        }
        class WL extends WindowAdapter
        {
            public void WindowClosing(WindowEvent e)
            {
                md.setVisible(false);
            }
        }
    }
}