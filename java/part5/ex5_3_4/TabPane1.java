import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TabPane1 extends JFrame 
{
    JPanel cp = new JPanel(); 
    JTabbedPane jtp = new JTabbedPane();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JButton jb1 = new JButton("in one");
    JButton jb2 = new JButton("in two");
    

    public TabPane1() {
        setTitle("try to use table");
        setSize(200, 300);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            System.exit(0);
            }
        });

        cp = (JPanel)this.getContentPane(); 
        ImageIcon icon = new ImageIcon("middle.gif");
        jp1.setLayout(new FlowLayout());
        jp1.add(jb1);
        jp2.setLayout(new FlowLayout());
        jp2.add(jb2);
        jtp.add(jp1,0);
        jtp.setTitleAt(0,"one");
        jtp.addTab("two", icon, jp2, "hellow");
        jtp.setSelectedIndex(0);
        jtp.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                jtpState(e);
            }
        });
        cp.add(jtp);
    }

    public static void main(String[] args) 
    {
        TabPane1 tabpane2 = new TabPane1();
        tabpane2.setVisible(true);    
    }
    void jtpState (ChangeEvent e) {
        String s = new String();
        jp3 = (JPanel)jtp.getSelectedComponent();
        if (jp3 == jp1) {
            s = "one";
        }
        if (jp3 == jp2) {
            s = "two";
        }
        this.setTitle(s+" is selected");
    }
}