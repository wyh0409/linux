import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class GL1 extends Applet
{
    public void init()
    {
        int i;

        setLayout(new GridLayout(7,3));
        for (i = 0; i < 20; i++) {
            add(new Button("Button"+i));
        }
    }
}
