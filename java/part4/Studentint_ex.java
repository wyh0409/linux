import java.util.*;

interface Birth
{
    int agetoyear(int a);
}

class person implements Birth
{
    protected String name;
    protected int age;
    public void setperson(String na, int ag)
    {
        name = na;
        age = ag;
    }
    public int agetoyear(int cy)
    {
        return cy-age+1;
    }
}

public class Studentint_ex
{
    public static void main(String arg[])
    {
        int year;
        person pe = new person();
        Calendar now = Calendar.getInstance();

        year = now.get(Calendar.YEAR);
        pe.setperson("Tom",20);
        System.out.println("The object os Person:"+pe.name+","+pe.age);
        System.out.println("born in"+pe.agetoyear(year));
    }
}

