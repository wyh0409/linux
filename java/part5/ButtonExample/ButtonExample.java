import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ButtonExample extends Applet implements ActionListener
{
    TextField name = new TextField(30);
    TextField pw = new TextField(30);
    TextField pw1 = new TextField(30);
    Label la1 = new Label();
    Label la2 = new Label();
    Label la3 = new Label();
    Button b1 = new Button("OK");

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == pw) {
            pw1.setText("action form pw textfield");
        } else if (e.getSource() == b1) {
            pw1.setText("action from b1 button");
        } else {
            
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

        pw.addActionListener(this);
        la3.setText("show password:");
        this.add(la3);
        this.add(pw1);
        this.add(b1);
        b1.addActionListener(this);
    }
}