import java.io.*;

public class FilebufIn {
    public static void main(String args[]) {
        String s = " ";
        try {
            FileReader rf = new FileReader("d:\\datafile\\file1.txt");
            BufferedReader brf = new BufferedReader(rf);

            String rs;
            while ((rs = brf.readLine()) != null) {
                s = s+rs+"\n";
            }

            brf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(s);
    }
}