import java.io.*;

public class Test8_6 {
    public static void main(String args[]) {
        try {
            int i = 0;
            FileOutputStream fout = new FileOutputStream("学生数据.dat", true);
            DataOutputStream dout = new DataOutputStream(fout);
            dout.writeInt(++i);
            dout.writeChars("张伟国"+"\n");
            dout.writeInt(++i);
            dout.writeChars("李志平"+"\n");
            dout.close();
        } catch (IOException e) {
            
        }
        try {
            FileInputStream fin = new FileInputStream("学生数据.dat");
            DataInputStream din = new DataInputStream(fin);
            int i = din.readInt();

            while (i != 1) {
                String name = " ";
                char ch;
                System.out.println(i+"   ");
                while ((ch = din.readChar()) != '\n') {
                    name = name+ch;
                }
                System.out.println(name);
                i = din.readInt();
            }
        } catch (Exception e2) {}
    }
}