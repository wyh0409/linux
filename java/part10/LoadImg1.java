import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class LoadImg1 extends JApplet {
    private ImageIcon img1;

    public void init() {
        img1 = new ImageIcon("meth.jpeg");
    }

    public void pint(Graphics g) {
        img1.paintIcon(this,g,0,0);
        g.drawImage(img1.getImage(),0,40,getWidth(),getHeight()-40,this);
    }
}