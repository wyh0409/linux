public class Stdin_out {
    public static void main(String args[]) {
        byte buffer [] = new byte[200];
        int i, d = 0, count = 0;
        System.out.println("Input a string:");
        try {
            count = System.in.read(buffer);
        } catch (Exception e) {
            System.out.println(e);
        }
        for (i = 0; i <= count-1; i++) {
            System.out.println((char)buffer[i]);
            System.out.println("Input ten char :");
            for ( i = 1; i <= 10; i++) {
                try {
                    d = System.in.read();
                    System.out.println((char)d);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
