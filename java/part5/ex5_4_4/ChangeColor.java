import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ChangeColor extends Applet implements ActionListener
{
    Label label1 = new Label();
    Button b1 = new Button("red");
    Button b2 = new Button("blue");
    Color newcolor;
    
    public void init() 
    {
        this.setBackground(Color.lightGray);
        this.setForeground(Color.black);
        label1.setText("please select colour:");
        this.setLayout(new FlowLayout());
        this.add(label1);
        this.add(b1);
        this.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        newcolor = Color.green;    
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b1) {
            newcolor = new Color(255, 0, 0);
            repaint();
        }
        if (e.getSource() == b2) {
            newcolor = new Color(0, 0, 255);
            repaint();
        }    
    }

    public void paint(Graphics g) {
        g.setColor(newcolor);
        g.fillOval(100, 100, 30, 30);
    }
}