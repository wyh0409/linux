public class TyChange 
{
    public static void main(String atgs[]) 
    {
        int i = 100;
        char c1 = 'a';
        byte b = 3;
        long l = 567L;
        float f = 1.89f;
        double d = 2.1;
        int i1 = i+c1;
        long l1 = l-i1;
        float f1 = b*f;
        double d1 = d+f1/i1;

        System.out.println("i1="+i1);
        System.out.println("l1="+l1);
        System.out.println("f1="+f1);
        System.out.println("d1="+d1);
    }
}
