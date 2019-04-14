public class Whileloopcode
{
    public static void main(String args[])
    {
    System.out.println("Limit");
    Limit();

    System.out.println("SquarRoot");
    SquarRoot();

    System.out.println("MuiTable");
    MuiTable();

    System.out.println("EvenNumber");
    EvenNumber();
    }

    public static void Limit()
    {
        int n = 0;
        float sum = 0;
        while (sum <= 10) {
            n += 1;
            sum += 1.0/n;
        }
        System.out.println("N="+n);
    }

    public static void SquarRoot()
    {
        int n = 0;
        long m = 1;
        do {
            System.out.println("n="+n+"\tt"+"10^"+n+"\t"+"squareroot="
                    +          Math.pow (m,1.0/2));
            n = n+1;
            m *= 10;
        }
        while (n <= 6);
    }

    public static void MuiTable()
    {
        int i, j;

        for (i = 1; i <= 9; i++) {
            for (j = 1; j <= 9; j++) {
                System.out.print(i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }

    public static void EvenNumber()
    {
        int i, j;
        for (i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i+"   ");
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
    
}
