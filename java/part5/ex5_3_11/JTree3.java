import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class JTree3 extends JFrame 
{
    JPanel cp = new JPanel();
    JTree jtree;
    DefaultMutableTreeNode root;
    JSplitPane jspanel = new JSplitPane();
    JScrollPane jscrpane1 = new JScrollPane();
    JScrollPane jscrpane2 = new JScrollPane();
    JTextArea jtal = new JTextArea("tree selected:");

    public JTree3() 
    {
        this.setTitle("try to use table");
        this.setSize(300, 300);
        cp = (JPanel)this.getContentPane();
        cp.setLayout(new BorderLayout());

        jspanel.setDividerSize(10);
        jspanel.setOneTouchExpandable(true);
        jspanel.setDividerLocation(150);

        root = new DefaultMutableTreeNode("school");
        createTree(root);
        jtree = new JTree(root);

        jscrpane1.getViewport().add(jtree);
        jspanel.add(jscrpane1,JSplitPane.LEFT);

        jscrpane2.getViewport().add(jtal);
        jspanel.setRightComponent(jscrpane2);
        cp.add(jspanel,BorderLayout.CENTER);

        jtree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode();
                node = (DefaultMutableTreeNode)jtree.getLastSelectedPathComponent();
                if (null == node) {
                    return;
                }
                Object info = node.getUserObject();
                if (node.isLeaf()) {
                    jtal.append(info.toString()+"is selected,it is a leaf"+"\n");
                } else {
                    jtal.append(info.toString()+"is selected,it is a not leaf"+"\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        JTree3 JTree3 = new JTree3();
        JTree3.setVisible(true);
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
                    classroom.add(number);
                }
            }
        }
    }
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}