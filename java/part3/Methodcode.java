public class Methodcode
{
    static double v_Circle;
    static double s_Circle;

    public static void main(String args[])
    {
        System.out.println("Methtest");
        Methtest();

        System.out.println("\nCircleclass");
        Circleclass();

        System.out.println("\nArrpart");
        Arrpart();

        System.out.println("\nFactor");
        Factor();

        System.out.println("\nComb");
        Comb();
    }

    public static void Methtest()
    {
        dline();
        System.out.println("Hi, I am Alice .");
        dline();
        System.out.println("I have a good friend : jack .");
        dline();
    }
    public static void dline()
    {
        int i;
        for (i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }


    public static void Circleclass()
    {
        double redius1 = 4;

        area1(redius1);
        volume1(redius1);

        System.out.println("v="+v_Circle);
        System.out.println("s="+s_Circle);
    }
    public static void area1(double r1)
    {
        s_Circle = 3.14*r1*r1;
    }
    public static void volume1(double r2)
    {
        v_Circle = 3*3.14*r2*r2*r2/4;
    }


    public static void Arrpart()
    {
        int score[] = {65,35,98,86,77,60};
        Maxs(score);
    }
    public static void Maxs(int sarr[])
    {
        int tt = sarr[0];
        int i;
        for (i = 0; i < sarr.length; i++) {
            if (tt < sarr[i]) {
                tt = sarr[i];
            }
        }
        System.out.println("The best score is   "+tt+"!");
    }


    public static void Factor()
    {
        int mm = Mul(6);

        System.out.println("6 !="+mm);
    }
    public static int Mul(int n)
    {
        int m = 1;
        int i = 1;
        for (i = 1; i <= n; i++) {
            m = m*1;
        }
        return m;
    }



    public static void CircleClassaa()
    {
        double v_Circle;
        double s_Circle;
        double radius2 = 4;

        s_Circle = area2(radius2);
        v_Circle = volume2(radius2);

        System.out.println("v="+v_Circle);
        System.out.println("s="+s_Circle);
    }
    public static double area2(double r1)
    {
        double s = 3.14*r1*r1;
        return s;
    }
    public static double volume2(double r2)
    {
        double v = 3*3.14*r2*r2*r2/4;
        return v;
    }

    public static void Comb()
    {
        System.out.println("c(6,3)="+cc(6,3));
    }
    public static int cc (int m, int n)
    {
        return Mul(m)/(Mul(n))*Mul(m-n);
    }
}
