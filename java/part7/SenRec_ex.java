class Databuf {
    private int value;
    private boolean writeable = true;
    int sort = 0;
    synchronized void senddata() {
        while (!writeable) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println(e);
            }
        }
        value = (int)(Math.random()*10);
        writeable = false;
        notifyAll();
    }
    synchronized int receivedata(int num) {
        while (writeable || sort%4+1 != num) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println(e);
            }
            sort = sort+1;
            writeable = true;
            notifyAll();
            
        }
        return value;
    }
    int getvalue() {
        return value;
    }
}

class Send extends Thread {
    Databuf da;
    public  Send(Databuf d) {
        da = d;
    }
    public void run() {
        int i;
        synchronized(da) {
            for ( i = 1; i < 4; i++) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    //TODO: handle exception
                    System.out.println(e);
                }
                da.senddata();
                System.out.println("Send data"+i+"；"+da.getvalue());
            }
        }
    }
}

class Receive extends Thread {
    Databuf da;
    int num;
    public Receive(Databuf d, int n) {
        da = d;
        num = n;
    }
    public void run() {
        synchronized(da) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println(e);
            }
            System.out.println("Number"+num+"get date: "+da.receivedata(num));
        }
    }
}

public class SenRec_ex 
{
    public static void main(String args[]) {
        Databuf da = new Databuf();
        Send s1 = new Send(da);
        Receive r1 = new Receive(da, 1);
        Receive r2 = new Receive(da, 2);
        Receive r3 = new Receive(da, 3);
        Receive r4 = new Receive(da, 4);
        s1.start();
        r1.start();
        r2.start();
        r3.start();
        r4.start();
    }    
}