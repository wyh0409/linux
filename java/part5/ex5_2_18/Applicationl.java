import java.awt.*;
import java.awt.event.*;
import java.applet.*;

 class Framel extends Frame
{
    public Framel() {
        Label la = new Label("hi");
        this.add(la);
        this.setSize(new Dimension(400,300));
        this.setTitle("My second Frame");
    }
}

public class Applicationl
{
    boolean packFrame = false;
    public Applicationl () 
    {
        Framel frame = new Framel();
        frame.setVisible(true);
    }
    public static void main (String[] args)
    {
        new Applicationl();
    }
}
