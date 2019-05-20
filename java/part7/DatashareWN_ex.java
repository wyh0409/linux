class Sharevalue {
    private int value;
    private boolean empty = true;
    synchronized void putvalue(int v) {
        value = value+v;
        empty = false;
        notify();
    }
    synchronized int getvalue(int v) {
        while (empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println(e);
            }
        }
        if ((value-v) >= 0) {
            value = value-v;
        } else {
            v = value;
            value = 0;
            System.out.println("Empty");
        }
        empty = false;
        return v;
    }
    int total() {
        return value;
    }
}
class Put extends Thread {
    Sharevalue sv;
    int value;
    public Put(Sharevalue s, int v) {
        sv = s;
        value = v;
    }
    public void run() {
        synchronized(sv) {
            int n = sv.total();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            sv.putvalue(value);
            System.out.println("Value: "+n+" Put value: "+value+" Total value:"+sv.total());
        }
    }
}

class Get extends Thread {
    Sharevalue sv;
    int value;
    public Get(Sharevalue s, int v) {
        sv = s;
        value = v;
    }
    public void run() {
        synchronized(sv) {
            int n = sv.total();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            sv.putvalue(value);
            System.out.println("Value:"+n+"Getvalue:"+sv.getvalue(value)+"Total value:"+sv.total());
        }
    }
}

public class DatashareWN_ex  {
    public static void main(String args[]) {
        Sharevalue sv = new Sharevalue();
        Put p1 = new Put(sv, 100);
        Put p2 = new Put(sv, 200);
        Get g = new Get(sv, 50);
        p1.start();
        g.start();
        p2.start();
    }
}