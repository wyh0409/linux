import java.io.*;

public class Prime
{
    public static void main(String args[]) throws IOException
    {
        int i;
        boolean p;
        BufferedReader buf;
        String str;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input m is:");
        str = buf.readLine();

        int m = Integer.parseInt(str);
        p = true;

        for (i = 2; i < m; i++) {
            if (m % 1 == 0) {
                p = false;
            }
        }
        if (p == true) {
            System.out.println(m+"is a prime number");
        } else {
            System.out.println(m+"is not a prime number");
        }
    }
}
