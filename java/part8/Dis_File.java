import java.io.*;
class ListFilter implements FilenameFilter {
    private  String pre = " ", ext = " ";

    public ListFilter(String filterstr) {
        int i, j;
        filterstr = filterstr.toLowerCase();
        i = filterstr.indexOf("*");
        j = filterstr.indexOf(".");

        if ( i > 0) {
            pre = filterstr.substring(0, i);
        } else if (i == -1) {
            if (j > 0) {
                pre = filterstr.substring(0, j-1);
            }
            if (j >= 0) {
                ext = filterstr.substring(j+1);
            }
        } else {}
    }

    public boolean accept(File dir, String filename) {
        boolean y = true;

        try {
            filename = filename.toLowerCase();
            y = filename.startsWith(pre)&filename.endsWith(ext);
        } catch (NullPointerException e) {}
        return y;
    }
}
public class Dis_File {
    public static void main(String args[]) {
        ListFilter ls = new ListFilter("b*.bmp");
        File f = new File("c:\\windows");
        System.out.println(f.getAbsolutePath());
        String str[] = f.list(ls);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}