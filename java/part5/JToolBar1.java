import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JToolBar1 extends JFrame{
	JPanel cp=new JPanel();
	JToolBar jtb=new JToolBar();
	JButton jb1=new JButton();
	JButton jb2=new JButton();
	JButton jb3=new JButton();
    JLabel jl=new JLabel("tool");
    
    public JToolBar1() {
    	setTitle("try to use toolbar");
    	setSize(300,300);
    	cp=(JPanel)this.getContentPane();
    	cp.setLayout(new BorderLayout());
    	this.addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			System.exit(0);
    		}
    	});
    	ImageIcon icon1=new ImageIcon("help.gif");
    	ImageIcon icon2=new ImageIcon("mmc.gif");
    	ImageIcon icon3=new ImageIcon("print.gif");
    	jb1.setIcon(icon1);
    	jb2.setIcon(icon2);
    	jb3.setIcon(icon3);
    	jtb.add(jl);
    	jtb.addSeparator();
    	jtb.add(jb1);
    	jtb.add(jb2);
    	jtb.add(jb3);
    	jtb.setFloatable(true);
    	cp.add(jtb,BorderLayout.SOUTH);
    }
    
    public static void main (String[] arg) {
    	JToolBar1 jtoolbar1 = new JToolBar1();
    	jtoolbar1.setVisible(true);
    	
    }
}
