import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PassFrame1 extends JFrame 
{
    JPanel cp = new JPanel();
    JPasswordField jpf = new JPasswordField(30);
    JLabel la = new JLabel();
    JButton jb1 = new JButton("OK     ",new ImageIcon("face5.gif"));
    JButton jb2 = new JButton("reinput",new ImageIcon("face4.gif"));
    JButton jb3 = new JButton("cancel ",new ImageIcon("face3.gif"));
    Jb1Listener jb11 = new Jb1Listener();
    Jb1Listener jb21 = new Jb1Listener();
    Jb1Listener jb31 = new Jb1Listener();

    public PassFrame1() 
    {
        cp = (JPanel)this.getContentPane();
        cp.setLayout(new FlowLayout());
        setTitle("try to use password:");
        setSize(200,300);
        jpf.setEchoChar('#');
        la.setIcon(new ImageIcon("face.gif"));
        la.setText("please input password:");
        jb1.addActionListener(jb11);
        jb2.addActionListener(jb21);
        jb3.addActionListener(jb31);
        cp.add(la);   
        cp.add(jpf);
        cp.add(jb1);
        cp.add(jb2);
        cp.add(jb3); 
    }

    protected void processWindowEvent (WindowEvent e) 
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }    
    }

    public static void main(String[] args) 
    {
        PassFrame1 passFrame1 = new PassFrame1();
        passFrame1.setVisible(true);    
    }

    class Jb1Listener implements ActionListener
    {
        public void actionPerformed (ActionEvent e) {
            jb1_actionperformed(e);
        }
    }

    void jb1_actionperformed(ActionEvent e) {
       String pw = new String(jpf.getPassword());
       if (pw.equals("thank")) {
           JOptionPane.showMessageDialog(null,"welcome");
       } else {
           JOptionPane.showMessageDialog(null,"worng password");
       } 
    }

    class Jb2Listener implements ActionListener
    {
        public void actionPerformed (ActionEvent e) {
            jb2_actionperformed(e);
        }
    }
    void jb2_actionperformed(ActionEvent e) {
        jpf.setText("");
    }

    class Jb3Listener implements ActionListener
    {
        public void actionPerformed (ActionEvent e) {
            jb3_actionperformed(e);
        }
    }
    void jb3_actionperformed(ActionEvent e) {
        System.exit(0);
    }

}