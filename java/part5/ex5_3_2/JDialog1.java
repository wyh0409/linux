import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;

public class JDialog1 extends JApplet 
{
    JButton jb1 = new JButton("show message input");
    JButton jb2 = new JButton("show message option");
    Container c = new Container();
    public void init() 
    {
        c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(jb1);
        c.add(jb2);
        jb1.addActionListener(new JButtonListener2()); 
        jb2.addActionListener(new JButtonListener2());      
    }  
    
    class JButtonListener2 implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) {
            String inputStr = new String();
            String[] select = {"red","blue","yellow","green"};
            int i;

            if (e.getSource() == jb1) {
                inputStr = JOptionPane.showInputDialog(null, "plase input:"
                                , "message input", JOptionPane.QUESTION_MESSAGE);
                JOptionPane.showMessageDialog(null, inputStr);
            } else if (e.getSource() == jb2) {
                i = JOptionPane.showOptionDialog(null, "please select", "color select",
                                    JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,
                                    null, select, select[0]);
                JOptionPane.showMessageDialog(null, select[i]);
            } else {}
        }
    }
}