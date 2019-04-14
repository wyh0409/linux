public class Circleclassp
{
    public static void main(String args[])
    {
        double radius = 4;

        System.out.println("Circleclass");
        area(radius);
        volume(radius);

        System.out.println("\nFactor11");
        Factor11();
    }

    static void area(double r1)
    {
        double s = 3.14*r1*r1;
        display("area",s);
    }
    static void volume(double r2)
    {
        double v = 3*3.14*r2*r2*r2/4;
        display("volum",v);
    }
    static void display(String st, double x)
    {
        System.out.println(st+"="+x);
    }

    static void Factor11()
    {
        int n = 10;
        System.out.println(n+"!="+Fact(n));
    }
    static long Fact(int n)
    {
        if (n == 1){
            return 1;
        } else {
            return n*Fact(n-1);
        }
    }
}
