import java.io.*;

public class FileIn_Out {
    public static void main(String args[]) {
        try {
            FileInputStream rf = new FileInputStream("d:\\datafile\\file1.txt");
            FileOutputStream wf = new FileOutputStream("d:\\datafile\\file2.txt");

            byte b[] = new byte[512];
            while ((rf.read(b,0,512)) != -1) {
                wf.write(b);
                rf.close();
                wf.close();
            }
        } catch (IOException ie) {
            System.out.println(ie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}