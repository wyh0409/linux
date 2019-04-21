import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class JTree2 extends JFrame {
    JPanel cp = new JPanel();
    JTree jtree;
    DefaultMutableTreeNode root;

    public JTree2() 
    {
        this.setTitle("try to use table");
        this.setSize(300, 300);
        cp = (JPanel)this.getContentPane();
        cp.setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("school");
        createTree(root);
        jtree = new JTree(root);
        cp.add(jtree,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JTree2 JTree2 = new JTree2();
        JTree2.setVisible(true);
    }

    private void createTree(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode classroom = null;
        DefaultMutableTreeNode number = null;
        int i = 1;

        classroom = new DefaultMutableTreeNode("classroom");
        root.add(classroom);

        for (i = 1; i <= 8; i++) {
            number = new DefaultMutableTreeNode("NO."+String.valueOf(i));

            if (i == 4) {
                for (int j = 0; i <= 5; j++) {
                    number.add(new DefaultMutableTreeNode("seat"+String.valueOf(j)));
                }
            }
            classroom.add(number);
        }
    }
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}
