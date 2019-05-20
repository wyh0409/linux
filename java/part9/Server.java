import java.net.*;
import java.io.*;

public class Server extends ServerSocket {
    private static final int SERVER_PORT = 10000;
    public Server() throws IOException {
        super(SERVER_PORT);
        try {
            while (true) {
                Socket socket = accept();
                new CreateServerThread(socket);
            }
        } catch (IOException e) {}
        finally{
            close();
        }
    }

    class CreateServerThread extends Thread {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public CreateServerThread(Socket s) throws IOException {
            client = s;
            in = new BufferedReader(new InputStreamReader(client.getInputStream(),"GB2312"));
            out.println("---Welcome---");
            start();
        }

        public void run() {
            try {
                String line = in.readLine();
                while (!line.equals("bye")) {
                    out.println(msg);
                    line = in.readLine();
                }
                out.println("--- See you bye---");
                client.close();
            } catch (IOException e) {}
        }
        private String createMessage(String line) {
            xxxxxxxxx;
        }
    }
    public static void main(String[] args) throws IOException {
        new Server();
    }
}