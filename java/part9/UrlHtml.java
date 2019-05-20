import java.net.*;
import java.io.*;

public class UrlHtml {
    public static void main(String args[]) {
        try {
            URL url = new URL(args[0]);
            InputStream inputstream = url.openStream();
            InputStreamReader file = new InputStreamReader(inputstream);
            BufferedReader in = new BufferedReader(file);
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch(MalformedURLException me) {}
        catch (IOException ioe) {}
    }
}