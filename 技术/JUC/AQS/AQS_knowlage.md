    AQS:技术解释：是用来构建锁或者其它同步器组件的重量级基础框架、及整个Juc体系的基石
        通过内置的FIFO队列来完成资源获取的排队工作，并通过一个int类型变量表示持有锁的状态
            0表示自由状态，1以及1以上表示占用状态。
    
    排队等待机制：如果共享资源被占用，就需要一定的阻塞等待唤醒机制来保证锁分配。
        这个机制主要用的是CLH队列的变体实现的，将暂时获取不到锁的线程加入到队列中，
        这个队列就是AQS的抽象表现。它将请求共享资源的线程封装成队列的结点(Node)，
        通过CAS、自旋以及LockSupport park()的方式，维护state变量的状态，使并发达到同步的控制效果。
    AQS使用一个volatile的int类型的成员变量来表示同步状态
     通过内置的FIFO队列来完成资源获取的排队工作将每条要去抢占赟源的线程封装成一个Node节点来实现锁的分配
     通过CAS完成对State值的修改。
    
    
    
    synchronized 实现原理、CAS无锁化的原理、AQS是什么、ConcurrentHashMap   
    锁的原理、线程池的原理、java内存模型、volatile说一下吗、对java并发包有什么了解?一连串的问题
    
    
    
