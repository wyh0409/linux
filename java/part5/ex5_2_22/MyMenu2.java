import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyMenu2 extends Applet 
{
    int icount;
    Integer count = new Integer(0);
    public void init()
    {
        icount = 0;
        new MyFrame2("one");
    }

    class MyFrame2 extends Frame
    {
        MenuBar mb1 = new MenuBar();
        Menu fi = new Menu("File");
        MenuItem[] file = {
            new MenuItem("new Frame",new MenuShortcut(KeyEvent.VK_F)),
            new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_E))
        };
        TextField tf = new TextField(10);

        public MyFrame2(String s) 
        {
            super(s);
            setSize(300, 300);
            setLayout(new FlowLayout());
            setMenuBar(mb1);
            mb1.add(fi);
            int i;

            for (i = 0; i < file.length; i++) {
                fi.add(file[i]);
            }

            ML ml1 = new ML();
            file[0].setActionCommand("new Frame");
            file[0].addActionListener(ml1);
            file[1].setActionCommand("Exit");
            file[1].addActionListener(ml1);
            add(tf);
            setVisible(true);
        }

        class ML implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                MenuItem target = (MenuItem)e.getSource();
                String ac = target.getActionCommand();

                if (ac.equals("new Frame")) {
                    icount++;
                    new MyFrame2("new"+count.toString(icount));
                    tf.setText("create new");
                } else if (ac.equals("Exit")) {
                    setVisible(false);
                } else {}
            }
        }
    }
}