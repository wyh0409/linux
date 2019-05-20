import java.net.*;
import java.io.*;

public class SocketC {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public SocketC() {
        try {
            socket = new Socket("127.0.0.1", 10000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String strLine = line.readLine();
                out.println(strLine);
                if (strLine.equals("bye")) {
                    break;
                }
                strLine = in.readLine();
                System.out.println("Server:"+strLine);
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        new SocketC();
    }
}