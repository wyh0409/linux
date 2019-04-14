import java.io.*;

public class DayCounter
{
    public static void main(String args[]) throws IOException
    {
        int year,month;
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input year number:");
        str = buf.readLine();
        year = Integer.parseInt(str);

        System.out.println("Input month number:");
        str = buf.readLine();
        month = Integer.parseInt(str);

        System.out.println(month+"/"+year+"has"+countDays(month, year)+"days.");
    }

    static int countDays(int month, int year)
    {
        int count = -1;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;

            case 2:
                if (year % 4 == 0 && year % 100 != 0 ||(year % 400 == 0)) {
                    count = 29;
                } else {
                    count = 28;
                }
                break;

            default:
                System.out.println("Input error");
        }
        return count;
    }
}
