public class Strcode 
{
    public static void main(String args[]) 
    {
        System.out.println("Strdemo");
        Strdemo();

        System.out.println("\nEqual");
        Equal();

        System.out.println("\nStrmethod");
        Strmethod();

        System.out.println("\n Calword");
        Caldword();

        System.out.println("\n SbufferTest");
        SbufferTest();
    }

    public static void Strdemo()
    {
        String st1 = "Jack", st2 = "Brown";
        String name = st1+" "+st2;
        double pi = 3.1415926;
        String stt = "Hello,"+st1;

        System.out.println("Name ="+name);
        
        System.out.println(stt+pi+2);
        System.out.println(pi+2+stt);
    }

    public static void Equal()
    {
        String str1 = "My Java";
        String str2 = "My Java";
        String str3 = "my java";
        
        String str4 = str2.trim();

        System.out.println(str1.equals(str4));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equalsIgnoreCase(str3));
    }

    public static void Strmethod()
    {
        String str = "Hello World:";

        System.out.println("charAt(6)="+str.charAt(6));
        System.out.println("length="+str.length());
        System.out.println("sub string="+str.substring(6));
        System.out.println("start with \"He\"="+str.startsWith("He"));
        System.out.println("upper case="+str.toUpperCase());
        System.out.println("\"World\"appares at " +str.indexOf("World",0)
                +" in\"  "+str+" \"");
    }

    public static void Caldword()
    {
        String s1 = "My friend welcome to java !";
        int n = 0;
        int i;

        System.out.println("The words of this sentence:");
        for (i = 0; i < s1.length(); i++) {
            char m = s1.charAt(i);

            if (Character.toLowerCase(m) < 97 
                || Character.toLowerCase(m) < 123) {
                n = n+1;
                }
        }
        System.out.println(n);
    }

    public static void SbufferTest()
    {
        StringBuffer str = new StringBuffer("sun & Moon");

        System.out.println("length="+str.length());
        System.out.println(str.replace(6,10,"star"));
        System.out.println(str.reverse());
        System.out.println(str);
    }
}
