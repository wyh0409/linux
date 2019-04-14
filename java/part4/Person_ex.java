import Firstpackage.*;

class Person
{
    String name;
    int age;
    public Person(String na, int ag)
    {
        name = na;
        age = ag;
    }

    public Person(){;}
    public int birth(int y)
    {
        return y-age+1;
    }
}

public class Person_ex
{
    public static void main(String args[])
    {
        int y;
        Person ps = new Person("Tom",21);
        Date now = new Date();
        y = now.thisyear();

        System.out.println(ps.name+"was born in "+ps.birth(y));
    }
}
