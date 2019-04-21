import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class ThrowsDemo extends JApplet
{
    public void init()
    {
        try {
            f();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void f() throws Exception 
    {
        throw new Exception("throw from f");
    }
}
