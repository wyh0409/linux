public class My2Array
{
    public static void main(String args[])
    {
        System.out.println("TwoDimArr");
        TwoDimArr();
        
        System.out.println("\nYanghui");
        Yanghui();
        
        System.out.println("\nArrcopy");
        Arrcopy();
    }

    public static void TwoDimArr() 
    {
        int i, j, sum = 0;
        int ssa[][] = {{20,25,26,22},{23,24,20,28}};

        for (i = 0; i < ssa.length; i++) {
            for (j = 0; j < ssa[i].length; j++) {
                System.out.print("ssa["+i+"]="+ssa[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void Yanghui()
    {
        int i,j;
        int yh1[][] = new int[8][];

        for (i = 0; i < 8; i++) {
            yh1[i] = new int[i+1];
            yh1[i][0] = 1;
            yh1[i][i] = 1;
        }

        for (i = 2; i < 8; i++) {
            for (j = 1; j < i; j++) {
                yh1[i][j] = yh1[i-1][j-1]+yh1[i-1][j];
            }
        }

        for (i = 0; i < 8; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print(yh1[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void Arrcopy()
    {
        int i;
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arr2[] = new int[10];
        System.arraycopy(arr1,0,arr2,0,arr1.length);

        for (i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+"   ");
        }
        System.out.println();
    }
}
