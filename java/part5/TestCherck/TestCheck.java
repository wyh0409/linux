//package texttareacheckbox;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TestCheck extends Applet
{
    TextArea ta1 = new TextArea("show result",5,10);
    Checkbox ck1 = new Checkbox("one",true);
    Checkbox ck2 = new Checkbox("two",false);
    Checkbox ck3 = new Checkbox("three",true);

    CheckboxGroup cg = new CheckboxGroup();
    Checkbox ck4 = new Checkbox("four",true,cg);
    Checkbox ck5 = new Checkbox("five",false,cg);
    Checkbox ck6 = new Checkbox("six",false,cg);

    class CheckListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            String source = (String)(e.getItem());
            if (source == "one") {
                if(e.getStateChange() == e.SELECTED) {
                    ta1.setText("one selected");
                } else {
                    ta1.setText("one deselected");
                }
            } else if (source == "two") {
                if(e.getStateChange() == e.SELECTED) {
                    ta1.setText("two selected");
                } else {
                    ta1.setText("two deselected");
                }
            } else if (source == "tree") {
                if(e.getStateChange() == e.SELECTED) {
                    ta1.setText("three selected");
                } else {
                    ta1.setText("three deselected");
                }
            } else {}

            if (source == "four") {
                if(e.getStateChange() == e.SELECTED) {
                    ta1.setText("four selected");
                }
            }
            if (source == "five") {
                if(e.getStateChange() == e.SELECTED) {
                    ta1.setText("five selected");
                }
            }
            if (source == "six") {
                if(e.getStateChange() == e.SELECTED) {
                    ta1.setText("six selected");
                }
            }
        }
    }
    public void init()
    {
        setLayout(new FlowLayout());
        add(ta1);
        add(ck1);
        add(ck2);
        add(ck4);
        add(ck5);
        add(ck6);
        ck1.addItemListener(new CheckListener());
        ck2.addItemListener(new CheckListener());
        ck3.addItemListener(new CheckListener());
        ck4.addItemListener(new CheckListener());
        ck5.addItemListener(new CheckListener());
        ck6.addItemListener(new CheckListener());
           
    }
    
}
