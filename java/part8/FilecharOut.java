import java.io.*;

public class FilecharOut {
    public static void main(String args[]) {
        char c[] = new char[512];
        byte b[] = new byte[512];
        int n, i;

        try {
            FileWriter wf = new FileWriter("d:\\datafile\\file3.txt");
            n = System.in.read(b);
            for (i = 0; i < n; i++) {
                c[i] = (char)b[i];
            }
            wf.write(c);
            wf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}