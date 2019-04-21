import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJMenu extends JApplet{
	JMenuBar jmb = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem item1=new JMenuItem("Open");
	JMenuItem item2=new JMenuItem("Save");
	JMenuItem item3=new JMenuItem("Close");
	JRadioButtonMenuItem JRMenuItem1=new JRadioButtonMenuItem("one",(Icon)new ImageIcon("face5.gif"));
	JRadioButtonMenuItem JRMenuItem2=new JRadioButtonMenuItem("two");
	ButtonGroup bgroup=new ButtonGroup();
	JPopupMenu popup=new JPopupMenu("my popup");
	JMenuItem it1=new JMenuItem("popup one");
	JPanel cp=new JPanel();
	public MyJMenu() {
		jmb.add(file);
		file.add(item1);
		file.add(item2);
		file.add(item3);
		file.addSeparator();
		bgroup.add(JRMenuItem1);
		bgroup.add(JRMenuItem2);
		file.add(JRMenuItem1);
		file.add(JRMenuItem2);
		
		popup.add(it1);
		it1=new JMenuItem("popup two");
		popup.add(it1);
		
	}
	public void init() {
		cp=(JPanel)this.getContentPane();
		setJMenuBar(jmb);
		cp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			cp_mouseClicked(e);
			}
		});
	}
	void cp_mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			popup.show(e.getComponent(),e.getX(),e.getY());
			
		}
	}
}
