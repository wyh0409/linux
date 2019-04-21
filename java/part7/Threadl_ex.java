public class Threadl_ex extends Thread
{
    char c;
    public Threadl_ex(String name, char c)
    {
        super(name);
        this.c = c;

    }

    public void run()
    {
        int k;
        char ch = c;
        
        System.out.println();
        System.out.println(getName()+":  ");
        for (k = 0; k <= 25; k++) {
            ch = (char)(c+k);
            System.out.print(ch+"  ");
        }
        System.out.println(getName()+" end !");
    }

    public static void main(String args[])
    {
        Threadl_ex th1 = new Threadl_ex("th1", 'A');
        Threadl_ex th2 = new Threadl_ex("th2", 'a');
        th1.start();
        th2.start();
        System.out.println("activeconunt="+Thread.activeCount());
    }
}
