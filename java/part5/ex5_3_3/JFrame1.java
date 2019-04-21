import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JFrame1 extends JFrame 
{
    public JFrame1() 
    {
        setSize(200, 200);
        setTitle("try to use processWindowEvent");
    }

    public static void main (String[] args) 
    {
        JFrame1 jframe1 = new JFrame1();
        jframe1.setVisible(true);    
    }
    protected void processWindowEvent (WindowEvent e) 
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);

        } else if (e.getID() == WindowEvent.WINDOW_ICONIFIED) {
            this.setIconImage((new ImageIcon("middle.gif")).getImage());

        } else if (e.getID() == WindowEvent.WINDOW_DEICONIFIED) {
            this.setIconImage(null);
        }
    }
}