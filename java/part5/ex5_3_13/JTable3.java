import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class JTable3 extends JFrame
{
    JPanel cp = new JPanel();
    JPanel panel = new JPanel(new FlowLayout());
    JTable jtable1;
    JTextArea ta = new JTextArea("selected:",10, 20);
    JScrollPane jscrp1 = new JScrollPane();
    JScrollPane jscrp2 = new JScrollPane();
    JButton jb = new JButton("show selected position");
    int SelectedRow = 0;
    int SelectedColumn = 0;

    public JTable3()
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
        
        ListSelectionModel rowSM = jtable1.getSelectionModel();

        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                SelectedRow = jtable1.getSelectedRow();
                ta.append("row change to:"+SelectedRow+"\n");
            }
        });

        ListSelectionModel colSM = jtable1.getSelectionModel();
                                        //.getSelectionModel();

        colSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                SelectedColumn = jtable1.getSelectedColumn();
                ta.append("row change to:"+SelectedColumn+"\n");
            }
        });

        /*jb.addActionListener(new ActionListener() {
            public void acthionPerformed(ActionEvent e) {
                ta.append("NOW AT row:"+SelectedRow+"Column"+SelectedColumn+"\n");
            }
        });*/

        jscrp1.getViewport().add(jtable1);
        jscrp2.getViewport().add(ta);
        panel.add(jscrp2);
        panel.add(jb);
        cp.add(jscrp1, BorderLayout.CENTER);
        cp.add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) 
    {
        JTable3 JTable3 = new JTable3();
        JTable3.setVisible(true);    
    }

    protected void processWindowEvent (WindowEvent e) 
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }    
    }
}