import java.io.*;

public class LeapYear
{
    public static void main(String args[]) throws IOException
    {
        int year;
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input the year:");
        str = buf.readLine();
        year = Integer.parseInt(str);

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("\nyear"+year+"is a leap year.");
        } else {
            System.out.println("\nyear"+year+"is not a leap year.");
        }
    }
}
