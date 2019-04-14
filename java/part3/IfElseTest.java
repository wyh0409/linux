import java.io.*;

public class IfElseTest
{
    public static void main(String args[]) throws IOException
    {
        int a,b;
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input an integer:");
        str = buf.readLine();
        a = Integer.parseInt(str);

        System.out.println("Input an integer:");
        str = buf.readLine();
        b = Integer.parseInt(str);

        if (a == b) {
            System.out.println("a equals b");

        } else {
            System.out.println("a dosen't equal b'");
        }
    }
}
