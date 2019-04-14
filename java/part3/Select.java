import java.io.*;

public class Select
{
    public static void main(String args[]) throws IOException
    {
        int a[] = {2,5,6,8,11,15,18,22,60,88};
        int m = 0, low = 0, high, x;
        BufferedReader buf;
        String str;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("请输入一个数：");
        str = buf.readLine();
        x = Integer.parseInt(str);

        high = a.length-1;
        while (low <= high) {
            m = (high+low)/2;
            if (x == a[m]) {
                break;
            } else if (x > a[m]) {
                low = m+1;
            } else {
                high = m-1;
            }
        }

        if (low <= high) {
            System.out.println(x+"已找到，位置是:"+m);
        } else {
            System.out.println(x+"未找到！");
        }
    }
}
