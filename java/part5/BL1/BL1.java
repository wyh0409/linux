import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class BL1 extends Applet
{
    public void init()
    {
        setLayout(new BorderLayout());
        add("North", new Button("north"));
        add("South", new Button("south"));
        add("East", new Button("east"));
        add("West", new Button("west"));
        add("Center", new Button("center"));
    }
}
