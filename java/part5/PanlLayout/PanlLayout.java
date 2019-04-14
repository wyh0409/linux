//package layout;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class ButtonsPanel extends Panel 
{
    ButtonsPanel(String id)
    {
        setLayout(new BorderLayout());
        add("North", new Button(id));
        add("South", new Button(id));
        add("East", new Button(id));
        add("West", new Button(id));
        add("Center", new Button(id));
    }
}

public class PanlLayout extends Applet
{
    Button first = new Button("first card");
    Button second = new Button("Second card");
    Button third = new Button("Third card");
    Panel cards = new Panel();
    CardLayout c1 = new CardLayout();

    public void init()
    {
        setLayout(new FlowLayout());

        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        p.add(first);
        p.add(second);
        p.add(third);
        add("North", p);

        cards.setLayout(c1);
        cards.add("card1",new ButtonsPanel("in the first card"));
        cards.add("card2", new ButtonsPanel("int the second card"));
        cards.add("card3", new ButtonsPanel("int the third card"));
        add("Center", cards);

        first.addActionListener(new addActionListenerOfButton());
        second.addActionListener(new addActionListenerOfButton());
        third.addActionListener(new addActionListenerOfButton());
    }

    class addActionListenerOfButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();
            if (source == first) {
                c1.first(cards);
            } else if (source == second) {
                c1.first(cards);
                c1.next(cards);
            } else if (source == third) {
                c1.last(cards);
            } else {

            }
        }
    }
}
