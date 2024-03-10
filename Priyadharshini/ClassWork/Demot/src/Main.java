import java.util.*;
public class Main {
    public static void main(String[] args) {
         Demo d=new Demo();
         Thread t1=new Thread(d);
         Thread t2=new Thread(d);
         t1.start();
         t2.start();
        System.out.println(d.count);
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        System.out.println(d.count);
        }
    }

class Demo implements Runnable{
        int count = 0;
        public synchronized void run ()
        {
            for (int i = 0; i <= 10000; i++) {
                count++;
            }
        }
    }

