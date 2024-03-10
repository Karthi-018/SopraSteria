import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Hi1 obj1 = new Hi1();
        Hello1 obj2 = new Hello1();
        obj1.start();
        obj2.start();
        obj1.setName("priya");
        try
        {
            obj1.join();
            obj2.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        System.out.println(obj1.getName());
        System.out.println(obj2.getName());
        System.out.println("Thread priority is "+obj1.getPriority());
//        System.out.println("Thread priority is "+obj2.getPriority());
    }
}
class Hi1 extends Thread{
   public void run()
 {
   show();
   }
    synchronized void show()//only after completing this next will run
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hi");
        }
    }
}
class Hello1 extends Thread
{
  public void run()
  {
      show();
  }
    void show()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello");
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }

}
