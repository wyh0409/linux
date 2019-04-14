import java.io.*;

public class SignClass
{
    public static void main(String args[]) throws IOException
    {
        double x;
        int y;
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input x is:");
        str = buf.readLine();
        x = Double.parseDouble(str);

        if (x > 0) {
            y = 1;
        } else if (x == 0 ) {
            y = 0;
        } else {
            y = -1;
        }
        System.out.println("y="+y);
    }
}
