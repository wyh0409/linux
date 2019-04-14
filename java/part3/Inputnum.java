import java.io.*;

public class Inputnum
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader buf;
        int num;
        String str;
        buf = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Input a string:");
        str = buf.readLine();
        
        num = Integer.parseInt(str);
        System.out.println("The integer is"+num);
    }
}
