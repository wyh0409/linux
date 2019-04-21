import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class JTable4 extends JFrame 
{
    
    JPanel cp = new JPanel();
    JTable jtable1 = new JTable();
    JTextArea ta = new JTextArea("input string is:"+"\n", 10, 20);
    JScrollPane jscrp1 = new JScrollPane();
    JScrollPane jscrp2 = new JScrollPane();
    
    public JTable4()
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

        final TableModel tm = jtable1.getModel();
        tm.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                Object date = tm.getValueAt(row,column);
                ta.append((String)date+"\n");
            }
        });

        jscrp1.getViewport().add(jtable1);
        jscrp2.getViewport().add(ta);
        cp.add(jscrp1,BorderLayout.CENTER);
        cp.add(jscrp2,BorderLayout.SOUTH);
    }

    public static void main(String[] args) 
    {
        JTable4 JTable4 = new JTable4();
        JTable4.setVisible(true);    
    }

    protected void processWindowEvent (WindowEvent e) 
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }    
    }
}