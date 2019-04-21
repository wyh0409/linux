import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitp1 extends JApplet{
	JPanel cp=new JPanel();
	JScrollPane jsp=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JLabel ImagL=new JLabel();
    JTextArea ta=new JTextArea();
    JScrollPane js=new JScrollPane(JScrollPane.HORIZONTAL_SPLIT);
    
    public JSplitp1() {
    	ImageIcon icon = new ImageIcon("castle.jpg");
    	ImagL.setIcon(icon);
    	jsp.setViewportView(ImagL);
    	js.setBorder(BorderFactory.createEtchedBorder());
    	js.setOneTouchExpandable(true);
    	js.setDividerLocation(100);
    	js.setDividerSize(20);
    	js.setLeftComponent(ta);
    	js.setRingtComponent(jsp);
    	cp=(JPanel)this.getContentPane();
    	cp.add(js);
    }
    public void init() {
    	this.setSize(new Dimension(300,300));
    	
    }
}
