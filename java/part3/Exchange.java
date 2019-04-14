public class Exchange
{
    public static void main(String args[])
    {
        int a,b,t;
        a = 2;
        b = 3;
        System.out.println("a="+a+"    "+"b="+b);

        t = a;
        a = b;
        b = t;
        System.out.println("a="+a+"    "+"b="+b);
    }
}
