import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class LX1 {
    public static void main(String args[]) {
        FileSave win = new FileSave();
    }
}

class FileSave extends Frame implements ActionListener {
    FileDialog f_Save;
    Button b;
    TextArea text;
    BufferedWriter out;
    FileWriter f_writer;
    FileSave () {
        super("打开保存文件对话框的窗口");
        b = new Button("保存文件对话框");
        setSize(300, 300);
        setVisible(true);
        b.addActionListener(this);
        f_Save = new FileDialog(this, "保存文件对话框", FileDialog.SAVE);
        f_Save.addWindowListener(new WindowAdapter () {
            public void windowClosing(WindowEvent e) {
                f_Save.setVisible(false);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        text = new TextArea(10,10);
        add(b, BorderLayout.NORTH);
        add(text, BorderLayout.CENTER);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        f_Save.setVisible(true);
        if (f_Save.getFile() != null) {
            try {
                File file = new File(f_Save.getDirectory(), f_Save.getFile());
                f_writer = new FileWriter(file);
                out = new BufferedWriter(f_writer);
                out.write(text.getText(), 0, (text.getText()).length());
                out.flush();
                out.close();
                f_writer.close();
            } catch (IOException e2) {
                //TODO: handle exception
            }
        }
    }
}