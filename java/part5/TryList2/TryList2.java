import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TryList2 extends Applet 
{
    List list = new List(6,false);
    TextField tf = new TextField(15);
    TextField tf1 = new TextField(15);
    Label la1 = new Label("action:");
    Label la2 = new Label("itme:");
    Panel p = new Panel();
    String[] description = {"red","blue","yellow"};
    int count = 0;

    public void init() 
    {
        int i;
        tf.setEditable(false);
        tf1.setEditable(false);

        for (i = 0; i < 3; i++) {
            list.addItem(description[count++]);
        }

        p.add(la1);
        p.add(tf);
        p.add(la2);
        p.add(tf1);
        add(p);
        add(list);
        list.addActionListener(new ListenActionItem());
        list.addItemListener(new ListenActionItem());
    }

    class ListenActionItem implements ActionListener,ItemListener
    {
        public void actionPerformed (ActionEvent e)
        {
            if (e.getActionCommand() == "red") {
                tf.setText("red double-clicked");
            } else if (e.getActionCommand() == "blue") {
                tf.setText("blue double-clicked");
            } else if (e.getActionCommand() == "yellow") {
                tf.setText("yellow double-clicked");
            } else {}
        }

        public void itemStateChanged (ItemEvent e) 
        {
            String source = list.getSelectedItem();
            if (source == "red") {
                tf1.setText("red selected");
            } else if (source == "blue") {
                tf1.setText("blue selected");
            } else if (source == "yellow") {
                tf1.setText("yellow selected");
            } else {}
        }
    }
}