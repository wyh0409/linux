import java.io.*;

public class Inputstr
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf;
        String str;

        buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a string");

        str = buf.readLine();
        System.out.println("String="+str);
    }
}
