Redisson之读写锁：
//保证一定能读到最新数据,修改期间，写锁是一个排他锁（互斥锁）。读锁是一个共享锁/写锁没释放读就必须等待
//读+读:相当于无锁
//写＋读:等待写锁释放
//写+写:阻塞方式
/读+写:等待读锁释放
闭锁（CountDownLatch）:
相当于计数器：预先设置一把锁的钥匙量数量，只有等钥匙全部开完锁之后，锁就会释放掉
基于Redisson的Redisson分布式闭锁（CountDownLatch）Java对象RCountDownLatch采用了与java.util.concurrent.CountDownLatch相似的接口和用法。
p:
RCountDownLatch latch = redisson.getCountDownLatch("anyCountDownLatch");
latch.trySetCount(1);
latch.await();
Redisson的作用：
  1、简化了redis的缓存操作。
  2、提供了各种可重入锁。
