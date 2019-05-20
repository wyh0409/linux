import java.net.*;
import java.io.*;

public class SocketSC {
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SocketSC() {
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
            in = new BufferedReader(new InputStreamReader(ips));
            out = new PrintWriter(ops, true);
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String strLine = line.readLine();
                System.out.println("Client:"+strLine);
                if (strLine.equals("bye")) {
                    break;
                }
                strLine = line.readLine();
                out.println(strLine);
            }

            ips.close();
            ops.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("错误！"+e);
        }
    }

    public static void main(String[] args) {
        new SocketSC();
    }
}