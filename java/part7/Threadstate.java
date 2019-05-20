import java.awt.*;
import java.awt.event.*;

public class Threadstate extends WindowAdapter 
{
    static Frame f;
    static Threadl th1, th2;
    public static void main(String args[]) {
        Threadstate ts = new Threadstate();
        ts.display();
        th1 = new Threadl("java Language");
        th2 = new Threadl("Program");
        th1.start();
        th1.setButton();
    }
    public void display() {
        f = new Frame("Threadstate");
        f.setSize(300,350);
        f.setLocation(300,150);
        f.setBackground(Color.lightGray);
        f.addWindowListener(this);
        f.setVisible(true);
    }
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

class Threadl extends Thread implements ActionListener 
{
    Panel p1;
    Label lab1;
    TextField tf1,tf2;
    Button b1,b2;
    int sleeptime = (int)(Math.random()*1000);
    public Threadl(String str)
    {
        super(str);
        for (int i = 0; i < 10; i++) {
            str = str+" ";
        }
        tf1 = new TextField(str);
        Threadstate.f.add(tf1);
        p1 = new Panel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        lab1 = new Label("sleep time");
        tf2 = new TextField(""+sleeptime);
        p1.add(lab1);
        p1.add(tf2);

        b1 = new Button("start");
        b2 = new Button("interrupt");
        p1.add(b1);
        p1.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        Threadstate.f.add(p1);
        Threadstate.f.setVisible(true);
    } 

    public void run() {
        String str;
        while (this.isAlive() &&!this.isInterrupted()) {
            try {
                str = tf1.getText();
                str = str.substring(1)+str.substring(0,1);
                tf1.setText(str);
                this.sleep(sleeptime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void setButton() {
        if (this.isAlive()) {
            b1.setEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Threadstate.th1.b1 || e.getSource() == Threadstate.th1.b2) {
            actionPerformed(e,Threadstate.th1);
        }
        if (e.getSource() == Threadstate.th2.b1 || e.getSource() == Threadstate.th2.b2) {
            actionPerformed(e,Threadstate.th2);
        }
    }

    public void actionPerformed(ActionEvent e, Threadl th) {
        if (e.getSource() == th.b1) {
            th.sleeptime = Integer.parseInt(th.tf2.getText());
            th.start();
        }
        if(e.getSource() == th.b2) {
            th.interrupt();
        }
        th.setButton();
    }
}