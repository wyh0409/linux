public class Transfercode
{
    public static void main(String args[])
    {
        System.out.println("Break");
        Break();
        System.out.println("Continue");
        Continue();
    }


    public static void Break()
    {
        int i;
        for (i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                break;
                System.out.println("i="+i);
            }
            System.out.println("when loop broken, i="+i);
        }
    }


    public static void Continute()
    {
        int i;
        for (i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                continue;
                System.out.println("i="+i);
            }
            System.out.println("when broken, i="+i);
        }
    }
}
