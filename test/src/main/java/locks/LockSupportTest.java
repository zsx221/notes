package locks;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
public class LockSupportTest {
    public  static void main (String[] t){
        Thread a=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" come in");
            LockSupport.park();//被堵塞
            LockSupport.park();//被堵塞
            System.out.println(Thread.currentThread().getName()+" 被唤醒"+System.currentTimeMillis());
        },"a");
        a.start();
        Thread b=new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           LockSupport.unpark(a);
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName()+" 通知了 "+a+System.currentTimeMillis());
        },"b");
        b.start();
    }
}
