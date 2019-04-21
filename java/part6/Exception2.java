public class Exception2
{
    int count = 1;

    public Exception2()
    {
        while (true) {
            try {
                int x = 6/(count--);
                System.out.println("int try,no exception");
            }
            catch (ArithmeticException e) {
                System.out.println("in catch,divided by zero");
            }
            finally {
                System.out.println("in finally");
                if (count == -1) {
                    break;
                }
            }
        }
        System.out.println("end of program");
    }
    public static void main(String args[])
    {
        Exception2 exception2 = new Exception2();
    }
}
