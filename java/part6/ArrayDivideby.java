//package ex6_3_1;
import java.awt.*;
import java.awt.Graphics;
import java.applet.*;

public class ArrayDivideby extends java.applet.Applet
{
    public static void main(String[] args) 
    {
        try {
            int I = 1, j = 0, f;
            try {
                int c[] = {1};
                c[12] = 99;
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("数组越界："+e);
            }
            f = I/j;
        }
        catch(ArithmeticException e)
        {
            System.out.println("被0除"+e);
        }
    }

  /*  public static void main(String args[])
    {
       paint pa = new  paint();
    }*/
}
