import java.net.*;
import java.io.*;

public class URL_FTP {
    public static void mian(String args[]) {
        byte data = 0;
        URL obj1;
        File obj2;
        DataInputStream inf = null;
        FileOutputStream outf = null;
        if (args.length != 2) {
            System.out.println("Download file!");
            System.out.println("Usage:java URL_FTP file file2");
            return;
        }

        try {
            obj1 = new URL(args[0]);
        } catch (MalformedURLException e) {
            System.out.println("Open URL "+args[0]+"Error");
            return;
        }

        obj2 = new File(args[1]);
        System.out.println("input file Description:");
        System.out.println("\tProtocol:"+obj1.getProtocol());
        System.out.println("\tHost    :"+obj1.getHost());
        System.out.println("\tPort    :"+obj1.getPort());
        System.out.println("\tFile    :"+obj1.getFile());
        System.out.println("\ttoString:"+obj1.toString());
        String s = obj2.getName();
        System.out.println(s);

        try {
            inf = new DataInputStream(obj1.openStream());
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        } catch (IOException e) {
            System.out.println("io error");
        }

        try {
            outf = new FileOutputStream(obj2);
        } catch (FileNotFoundException e) {
            System.out.println("file2 not found!");
        } catch (IOException e) {
            System.out.println("Open Data Stream Error");
            return;
        }

        try {
            do {
                data = (byte)inf.readByte();
                outf.write(data);
            } while (true);
        } catch (EOFException e) {
            System.out.println("File Download Complete");
        } catch (IOException e) {
            System.out.println("File Download Error");
            return;
        }

        try {
            inf.close();
        } catch (IOException e) {}
    }
}