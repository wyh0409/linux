import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class File_Open {
    public static void main(String args[]) {
        FileOpen win = new FileOpen();
    }
}

class FileOpen extends Frame implements ActionListener {
    FileDialog f_Open;
    Button b;
    TextArea text;
    BufferedReader in;
    FileReader f_reader;

    FileOpen() {
        super("打开文件对话框的窗口");
        b = new Button("打开文件对话框");
        setSize(300, 300);
        setVisible(true);
        b.addActionListener(this);
        f_Open = new FileDialog(this,"打开文件对话框", FileDialog.LOAD);
        f_Open.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f_Open.setVisible(false);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        text = new TextArea(10, 10);
        add(b,BorderLayout.NORTH);
        add(text,BorderLayout.CENTER);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        f_Open.setVisible(true);
        text.setText(null);
        String s;
        if (f_Open.getFile() != null) {
            try {
                File file = new File(f_Open.getDirectory(), f_Open.getFile());
                f_reader = new FileReader(file);
                in = new BufferedReader(f_reader);
                while ((s = in.readLine()) != null) {
                    text.append(s+'\n');
                }
                in.close();
                f_reader.close();
            } catch (IOException e2) {
                //TODO: handle exception
            }
        }
    }
}