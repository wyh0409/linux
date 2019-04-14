public class Forloopcode
{
    public static void main(String args[])
    {
        int i;
        int sum = 0;

        for(i = 1; i <= 100; i++) {
            sum+=i;
        }

        System.out.println("1+2+3...+100="+sum);

        Fibonacci();
    }

    public static void Fibonacci()
    {
        int m = 1;
        int n = 1;
        System.out.println(m+"  ");

        for (int i = 2; i <= 30; i++) {
            System.out.print(n+" ");
            
            if(i % 10 == 0) {
                System.out.println("\n");
            }
            n = n+m;
            m = n-m;
        }
    }
}
