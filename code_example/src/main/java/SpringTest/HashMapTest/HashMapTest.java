package SpringTest.HashMapTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
@Slf4j
public class HashMapTest {
    Object o=new Object();
    int i=0;
    HashMap<String,String>map=new HashMap<>();
    @Test
    public void tesr1(){
        log.info("");
    }
    @Test
    public void test2(){
        threadTest threadTest1 = new threadTest();
        threadTest threadTest2 = new threadTest();
        new  Thread(threadTest1).start();
        new  Thread(threadTest2).start();
    }
    class threadTest implements Runnable{
        @Override
        public  void run() {
            synchronized(threadTest.class){
                for (;i<100;i++)
                    System.out.println(i+Thread.currentThread().getName());
            }
            }

    }
}
