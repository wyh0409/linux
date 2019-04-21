import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class FontDemo extends Applet 
{
    public void paint(Graphics g) 
    {
        
        Font font = new Font("宋体",Font.ITALIC,16);

        g.setFont(font);
        g.drawString("是宋体 斜体 16号大小",20,20);   
    }    
}