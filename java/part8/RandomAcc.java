import java.io.*;

public class RandomAcc {
    private int d;
    public void creat(RandomAccessFile rwf) {
        int i, j, k, t;
        try {
            rwf.seek(0);
            for ( i = 1; i <= 10; i++) {
                d = (int)(Math.random()*100)+1;
                if (i == 1) {
                    rwf.writeInt(d);
                } else {
                    if (d > rwf.readInt()) {
                        rwf.seek((i-1)*4);
                        rwf.writeInt(d);
                    } else {
                        for ( j = 1; j <= i-1; j++) {
                            rwf.seek((j-1)*4);
                            if (d < rwf.readInt()) {
                                break;
                            }
                        }

                        for (k = i-1; k >= j; k--) {
                            rwf.seek((k-1)*4);
                            t = rwf.readInt();
                            rwf.seek(k*4);
                            rwf.writeInt(t);
                        }
                        rwf.seek((j-1)*4);
                        rwf.writeInt(d);
                    }
                }
                rwf.seek((i-1)*4);
            }
        } catch (EOFException e) {}
        catch (IOException e) {}
    }

    public void showdata(RandomAccessFile rwf) {
        int i = 0,d = 0;
        try {
            rwf.seek(i*4);
            while (true) {
                d = rwf.readInt();
                System.out.println(d+",");
                i++;
                rwf.seek(i*4);
            }
        } catch (EOFException e) {} 
        catch (IOException e) {}
    }

    public static void main(String args[]) {
        try {
            RandomAcc ra = new RandomAcc();
            RandomAccessFile rwf = new RandomAccessFile("d:\\datafile\\file3.dat","rw");
            ra.creat(rwf);
            ra.showdata(rwf);
            rwf.close();
        } catch (FileNotFoundException e) {
            //TODO: handle exception
        } catch (IOException e) {}
    }
}