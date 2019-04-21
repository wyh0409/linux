import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class JTable1 extends JFrame 
{
    
    JPanel cp = new JPanel();
    JTable jtable1;
    JScrollPane jscrp1 = new JScrollPane();

    public void JTable1()
    {
        cp = (JPanel)this.getContentPane();
        this.setTitle("try to use table");
        this.setSize(500, 500);
        cp.setLayout(new BorderLayout());

        Object[][] date = {
            {"jenny","female","football",new Integer(20),"ENGLISH"},
            {"may","female","music", new Integer(20), "ENGLISH"},
            {"Lili","female","art", new Integer(20), "chinese"}
        };

        Object[] columnNames = {"name","six","hobby","age","nationality"};

        jtable1 = new JTable(date, columnNames);
        jtable1.setRowHeight(20);

        jscrp1.getViewport().add(jtable1);
        cp.add(jscrp1);
    }
    public static void main(String[] args) 
    {
    
        JTable1 JTable1 = new JTable1();
        JTable1.setVisible(true);   
    }

    protected void processWindowEvent (WindowEvent e) 
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }    
    }
}