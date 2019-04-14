import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TryChoice extends Applet 
{
    String[] description = {"red","bule","yellow","orange","pink",
                            "grey","green","black","brown"};
    TextArea t = new TextArea(5,30);
    Choice c = new Choice();

    public void init() 
    {
        int i;
        t.setEditable(false);
        for (i = 0; i < 9; i++) {
            c.addItem(description[i]);
        }
            add(t);
            add(c);
            c.addItemListener(new CL());
        
    }
    class CL implements ItemListener 
    {
        public void itemStateChanged(ItemEvent e) 
        {
            t.append("\n"+"index:"+c.getSelectedIndex()
                    +"\n"+c.getSelectedItem()+"is selected");
        }
    }
}