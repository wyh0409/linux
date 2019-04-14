import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Key extends Applet
{
    TextField tf1 = new TextField(10);
    TextField tf2 = new TextField(10);
    Label la = new Label();
    Label la2 = new Label();

    public void init()
    {
        //this.setLayout(new FlowLayout());
        la.setText("tf1:");
        add(la);
        add(tf1);

        la2.setText("tf2:");
        add(la2);
        add(tf2);

        tf1.addKeyListener(new TextFieldKeyListener());
    }

    class TextFieldKeyListener extends KeyAdapter
    {
        public void keyTyped(KeyEvent e)
        {
            tf2.setText(tf1.getText());
        }
    }
}
