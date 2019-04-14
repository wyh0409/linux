public class Arraycode
{
    public static void main(String args[])
    {
        System.out.println("FirstArray");
        FirstArray();
        
        System.out.println("\nChar");
        Char();
        
        System.out.println("\nGNum");
        GNum();

        System.out.println("\nMaxMin");
        MaxMin();

        System.out.println("\nYangHui");
        YangHui();

        System.out.println("\nSort12");
        Sort12();
    }

    public static void FirstArray()
    {
        int i;
        int aa[] = new int[5];

        for (i = 0; i < 5; i++) {
            System.out.print("aa["+i+"]="+aa[i]+",\t");
        }
        System.out.println("\nlenth of array aa is"+aa.length);
    }

    public static void Char()
    {
        int i;
        char str[] = {'h','e','l','l','o','!'};

        for (i = 0; i < str.length; i++ ) {
            System.out.print(str[i]);
        }
    }

    public static void GNum()
    {
        int i;
        int aa[] = new int[5];
        for (i = 0; i < 5; i++) {
            aa[i] = 2*i+1;
            System.out.print("a["+i+"]="+aa[i]+"\t");
        }
    }

    public static void MaxMin()
    {
        int i, min, max;
        int mm[] = {65,89,42,77,62,54};

        min = max = mm[0];
        System.out.print("Elements in array mm are");

        for (i = 0; i < mm.length; i++) {
            System.out.print(mm[i]+"   ");
            if (mm[i] > max) {
                max = mm[i];
            }
            if (mm[i] < min) {
                min = mm[i];
            }
        }
        System.out.println("\nMaxmum is "+max);
        System.out.println("\nMinmum is "+min);
    }

    public static void YangHui()
    {
        int i;
        int j;
        int yh[] = new int[8];
        
        for (i = 0; i < 8; i++) {
            yh[i] = 1;
            for (j = i-1; j > 0; j--) {
                yh[j] = yh[j-1]+yh[j];
            }
            for (j = 0; j <= i; j++) {
                System.out.print(yh[j]+"\t");
            }
            System.out.println();
        }
    }

    public static void Sort12()
    {
        int i, j, t;
        int mp[] = {8,6,12,5,14,7,21,2,9,3};

        System.out.println("The original 10 number:");
        for (j = 0; j < mp.length; j++) {
            System.out.print(mp[j]+"\t");
        }
        System.out.println();

        for (i = 0; i < mp.length-1; i++) {
            for (j = i; j < mp.length; j++) {
                if (mp[i] > mp[j]) {
                    t = mp[i];
                    mp[i] = mp[j];
                    mp[j] = t;
                }
            }
        }
        System.out.println("The sorted 10 number:");

        for (j = 0; j < mp.length; j++) {
            System.out.print(mp[j]+"\t");
        }
    }
}
