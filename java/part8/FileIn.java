import java.io.*;

public class FileIn {
    public static void main(String args[]) {
        try {
            FileInputStream rf = new FileInputStream("d:\\datafile\\file1.txt");
            int b;
            while ((b = rf.read()) != -1) {
                System.out.println((char)b);
                rf.close();
            }
        } catch (IOException ie) {
            System.out.println(ie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}