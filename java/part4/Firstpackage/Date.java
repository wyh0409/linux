package Firstpackage;
import java.util.*;

public class Date
{
    private int year, month, day;
    public Date(int y, int m, int d)
    {
        year = y;
        month = m;
        day = d;
    }
    public Date( ){;}
    public int thisyear( )
    {
        return Calendar.getInstance( ).get(Calendar.YEAR);
    }
}
