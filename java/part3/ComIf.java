import java.io.*;

public class ComIf
{
    public static  void main(String args[]) throws IOException
    {
        int a,b,c,t;
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Input first number:");
        str = buf.readLine();
        a= Integer.parseInt(str);

        System.out.println("Input second number:");
        str = buf.readLine();
        b = Integer.parseInt(str);

        System.out.println("Input third number:");
        str = buf.readLine();
        c = Integer.parseInt(str);

        if(a > b) {
            t = a;
            a = b;
            b = t;
        }
        if(a > c) {
            t = a;
            a = c;
            c = t;
        }
        if(b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println(a+",");
        System.out.println(b+",");
        System.out.println(c);
    }
}
