package SpringTest.locks;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTest implements Runnable {

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentrantTest rt = new ReentrantTest();
        for(int i=0;i<10;i++){
            new Thread(rt).start();
        }
    }
    @Test
    public void Aqstest(){
        ReentrantLock lock=new ReentrantLock();
        Object o=new Object();
        new Thread(()->{
            lock.lock();
            try {
                o.wait(3l);
                o.wait(3l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上锁");
            lock.lock();
            System.out.println("再次上锁");
        },"a").start();
        new Thread(()->{
            lock.unlock();
            o.notify();
            System.out.println("解锁成功");
        },"c").start();
        System.out.println("解锁成功锁");
    }
}
