public class CompOperating{
    public static void main(String args[]){
        int a = 5, b = 8;
        System.out.println("Befor calculate: a="+a+", b="+b);
        a+=b;

        System.out.println("After += calculate: a="+a+", b="+b);
        a-=b;

        System.out.println("After -= calculate: a="+a+", b="+b);
        a*=b;

        System.out.println("After *= calculate: a="+a+", b="+b);
        a/=b;
        
        System.out.println("After /= calculate: a="+a+", b="+b);
    }
}
