import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyMenu1 extends Applet 
{
    MyFrame frame = new MyFrame("hi");
    Button b1 = new Button("open");
    Button b2 = new Button("close");
    TextField tf1 = new TextField(20);

    MenuBar mb1 = new MenuBar();
    Menu fi = new Menu("File");
    Menu e = new Menu("Edit");
    Menu s = new Menu("Search");

    Menu v = new Menu("View");
    CheckboxMenuItem[] vie = {
        new CheckboxMenuItem("Text"),
        new CheckboxMenuItem("Html")
    };

    MenuItem[] file = {
        new MenuItem("open",new MenuShortcut(KeyEvent.VK_O)),
        new MenuItem("Save",new MenuShortcut(KeyEvent.VK_S)),
        new MenuItem("Exit",new MenuShortcut(KeyEvent.VK_E))
    };
    MenuItem[] edit = {
        new MenuItem("Copy",new MenuShortcut(KeyEvent.VK_C)),
        new MenuItem("Cut",new MenuShortcut(KeyEvent.VK_U)),
        new MenuItem("Paste",new MenuShortcut(KeyEvent.VK_P))
    };
    MenuItem[] search = {
        new MenuItem("Find",new MenuShortcut(KeyEvent.VK_F)),
        new MenuItem("Replace",new MenuShortcut(KeyEvent.VK_R))
    };
    ML ml1 = new ML();
    MIL mil1 = new MIL();
    WL fw1 = new WL();

    public void init()
    {
        int count;

        add(b1);
        add(b2);
        add(tf1);
        frame.setMenuBar(mb1);
        mb1.add(fi);

        for (count = 0; count < file.length; count++) {
            fi.add(file[count]);
        }
        for (count = 0; count < vie.length; count++) {
            v.add(vie[count]);
        }
        fi.add(v);

        mb1.add(e);
        for (count = 0; count < edit.length; count++) {
            e.add(edit[count]);
        }

        mb1.add(s);
        for (count = 0; count < search.length; count++) {
            s.add(search[count]);
        }

        b1.addActionListener(new B1L());
        b2.addActionListener(new B2L());
        file[0].setActionCommand("open");
        file[0].addActionListener(ml1);

        file[1].setActionCommand("Save");
        file[1].addActionListener(ml1);

        file[2].setActionCommand("Exit");
        file[2].addActionListener(ml1);

        vie[0].setActionCommand("Text");
        vie[0].addItemListener(mil1);

        vie[1].setActionCommand("Html");
        vie[1].addItemListener(mil1);
        frame.addWindowListener(fw1);
        frame.setSize(200,300);
    }

    class WL extends WindowAdapter
    {
        public void windowClosing (WindowEvent e) 
        {
            frame.setVisible(false);
        }
    }

    class B1L implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            frame.setVisible(true);
        }
    }

    class B2L implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            frame.setVisible(false);
        } 
    }
    
    class MyFrame extends Frame 
    {
        Label la1 = new Label("My Applet Frame");
        TextField tf = new TextField(20);
        MyFrame(String s) 
        {
            super(s);
            setLayout(new FlowLayout());
            add(la1);
            tf.setEditable(false);
            add(tf);
            tf.setText("I am in the frame");
        }
    }

    class ML implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            MenuItem target = (MenuItem)e.getSource();
            String ac = target.getActionCommand();

            if (ac.equals("Open")) {
                tf1.setText("select open");

            } else if (ac.equals("Save")) {
                tf1.setText("select save");

            } else if (ac.equals("Exit")) {
                frame.setVisible(false); 
            }
        }
    }

    class MIL implements ItemListener
    {
        public void itemStateChanged(ItemEvent e) 
        {
            CheckboxMenuItem target = (CheckboxMenuItem)e.getSource();
            String acommand = target.getActionCommand();

            if (acommand.equals("Text")) {
                tf1.setText("Text is "+target.getState());

            } else if (acommand.equals("Html")) {
                tf1.setText("Html is"+target.getState());
            }
        }
    }
}