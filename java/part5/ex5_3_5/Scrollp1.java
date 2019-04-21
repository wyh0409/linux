import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Scrollp1 extends JFrame {
    JPanel cp = new JPanel();
    JScrollPane jsp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JLabel ImagL = new JLabel();

    public Scrollp1() {
        ImageIcon icon = new ImageIcon("castle.jpg");
        ImagL.setIcon(icon);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jsp.setViewportView(ImagL);
        cp = (JPanel)this.getContentPane();
        this.setSize(new Dimension(300, 300));
        cp.add(jsp);
    }

    public static void main(String[] args) {
        Scrollp1 scrollp11 = new Scrollp1();
        scrollp11.setVisible(true);
    }
}