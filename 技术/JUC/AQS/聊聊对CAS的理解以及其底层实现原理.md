    4    聊聊对CAS的理解以及其底层实现原理？
    乐观锁
     取值，询问，修改  
        多个线程他们可能要访问同一个数据
        HashMap map = new HashMap();
        此时有多个线程要同时读写类似上面的这种内存里的数据，此时必然出现多线程的并发安全问题，几个月培训班的同学，都应该知道
        我们可能要用到并发包下面的很多技术, synchronized
        
        CAS:compare and set 字面意思就是比较并交换，cas是基于锁的操作，是乐观锁，保证了原子性
         它的功能是判断内存某个位置的值是否为预期值,如果是则更改为新的值,这个过程是原子的
    ![](E:\Pictures\java_learn\CAS\CAS_Expretition.png)
