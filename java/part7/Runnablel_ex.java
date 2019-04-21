
public class Runnablel_ex  implements Runnable
{
    char c;
    public Runnablel_ex(char c)
    {
        this.c = c;
    }
    public void run()
    {
        int k;
        char ch = c;
        System.out.println();
        System.out.print(Thread.currentThread().getName()+":  ");
        /*用Runnable接口时直接用getName不行要加上Thread.currentThread() */
        
        for (k = 0; k <= 25; k++) {
            ch = (char)(c+k);
            System.out.print(ch+"  ");
        }
        System.out.println(Thread.currentThread().getName()+" end !");
    }

    public static void main(String args[])
    {
        Runnablel_ex run1 = new Runnablel_ex('A');
        Runnablel_ex run2 = new Runnablel_ex('a');
        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);
        th1.start();
        th2.start();
        System.out.println("activecount="+Thread.activeCount());
    }
}
