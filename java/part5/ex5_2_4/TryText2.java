import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class TryText2 extends Applet
{
    TextField name = new TextField(30);
    TextField pw = new TextField(30);
    TextField pw1 = new TextField(30);
    Label la1 = new Label();
    Label la2 = new Label();
    Label la3 = new Label();

    class PasswordHandle implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            pw1.setText(pw.getText());
        }
    }

    public void init()
    {
        this.setLayout(new FlowLayout());
        la1.setText("        name:");
        this.add(la1);
        this.add(name);

        la2.setText("    passowrd:");
        this.add(la2);
        pw.setEchoChar('*');
        this.add(pw);

        pw.addActionListener(new PasswordHandle());
        la3.setText("show password:");
        this.add(la3);
        this.add(pw1);
    }
}
