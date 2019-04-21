import java.awt.*;
import java.awt.event.*;
import java.applet.*;
 
public class MenuOnly extends Applet 
{
    MyFrame frame = new MyFrame("hi menuonly");
    Button b1 = new Button("open");
    Button b2 = new Button("close");

    MenuBar mb1 = new MenuBar();
    Menu fi = new Menu("File");

    MenuItem[] file = {
        new MenuItem("open",new MenuShortcut(KeyEvent.VK_O)),
        new MenuItem("Save",new MenuShortcut(KeyEvent.VK_S)),
        new MenuItem("Exit",new MenuShortcut(KeyEvent.VK_E))
    };

    public void init() 
    {
        int count;

        add(b1);
        add(b2);
        frame.setMenuBar(mb1);
        mb1.add(fi);
        for (count = 0; count < file.length; count++) {
            fi.add(file[count]);
        }

        b1.addActionListener(new B1L());
        b2.addActionListener(new B2L());
        frame.setSize(200,300);
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
        MyFrame(String s) 
        {
            super(s);
            setLayout(new FlowLayout());
            add(la1);
        }
    }
}