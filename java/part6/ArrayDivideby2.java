import java.awt.Graphics;
public class ArrayDivideby2 extends java.applet.Applet
{
    public static void main(String[] args)
    {
        try {
            int I = 1, j = 0, f; 
            Array();
            f = I/j;
        }
        catch (ArithmeticException e) {
            System.out.println("被0除异常"+e);
        }
    }
    
    static void Array() {
        try {
            int c[] = {1};
            c[2] = 99;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标异常"+e);
        }
    }
}
