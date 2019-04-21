public class Frame1
{
    public Frame1 ()
    {
        int d = 0;
        int a = 10/d;
        System.out.println("never run this sentence");
    }

    public static void main(String[] args)
    {
        Frame1 framel = new Frame1();
    }
}
