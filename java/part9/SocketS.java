import java.net.*;
import java.io.*;

public class SocketS {
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public SocketS() {
        try {
            try {
                ss = new ServerSocket(10000);
            } catch (IOException e) {
                System.out.println("监听端口出错！"+e);
            }

            try {
                socket = ss.accept();
            } catch (IOException e) {
                System.out.println("连接出错！"+e);
            }

            InputStream ips = socket.getInputStream();
            OutputStream ops = socket.getOutputStream();
            ops.write("Welcome!".getBytes());
            byte[] buf = new byte[1024];
            int len = ips.read(buf);
            System.out.println(new String(buf,0,len));
            ips.close();
            ops.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("错误！"+e);
        }
    }

    public static void main(String[] args) {
        new SocketS();
    }
}