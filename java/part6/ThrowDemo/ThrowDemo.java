import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Graphics;
import java.applet.*;

public class ThrowDemo extends Applet
{
    JTextField tf1 = new JTextField("try to use throw",50);
    JTextField tf2 = new JTextField("this will not show on the screen");

    public void init()
    {
        try {
            Container cp = new Container();
            cp = this.getContentPane();
            cp.setLayout(new BorderLayout());
            cp.add(tf1, BorderLayout.NORTH);
            demo();
            cp.add(tf2);
        }
        catch(NullPointerException e) {
            tf1.setText("catch an exception"+e);
        }
    }
    void demo() {
        throw new NullPointerException("this exception is thrown by init");
    }
}