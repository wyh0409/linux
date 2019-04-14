//package ex5_2_2;
import java.awt.*;
import java.applet.*;

public class TryText extends Applet
{
    TextField name = new TextField(30);
    TextField pw = new TextField(30);
    Label la1 = new Label();
    Label la2 = new Label();

    public void init()
    {
        this.setLayout(new FlowLayout());
        la1.setText("name:");
        this.add(la1);
        this.add(name);

        la2.setText("password:");
        this.add(la2);
        pw.setEchoChar('*');
        this.add(pw);
    }
}
