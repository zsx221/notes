        4大常见的并发工具类
            countDownLatch、CyclicBarrier、Semaphore、ExChanger
        CountDownLatch：俗称闭锁,作用是类似加强版的Join,是让一组线程等待其他的线程完成工作以后才执行
            CountDownLatch:初始化方法
            await:等待方法,同时带参数的是超时重载方法
            countDown:每执行一次,计数器减一,就是初始化传入的数字,也代表着一个线程完成了任务
            getCount:获取当前值
            toString:这个就不用说了
            主线程中创建CountDownLatch(3),然后主线程await阻塞,然后线程A,B,C各自完成了任务,调用了countDown,之后,每个线程调用一次计数器就会减一
            初始是3,然后A线程调用后变成2,B线程调用后变成1,C线程调用后,变成0,这时就会唤醒正在await的主线程,然后主线程继续执行

        CyclicBarrier,俗称栅栏锁,作用是让一组线程到达某个屏障,被阻塞,一直到组内的最后一个线程到达,然后屏障开放,接着,所有的线程继续运行
                这个感觉和CountDownLatch有点相似,但是其实是不一样的,所谓的差别,将在下面详解CyclicBarrier的构造参数有两个
        主线程创建CyclicBarrier(3,barrierAction),然后由线程开始执行,线程A,B执行完成后都调用了await,然后他们都在一个屏障前阻塞者
            需要等待线程C也,执行完成,调用await之后,然后三个线程都达到屏障后,屏障开放,然后线程继续执行,并且barrierAction在屏障开放的一瞬间也开始执行

        Semaphore,俗称信号量,作用于控制同时访问某个特定资源的线程数量,用在流量控制一说特定资源控制,那么第一时间就想到了数据库连接..
        之前用等待超时模式写了一个数据库连接池,打算用这个Semaphone也写一个

        Exchanger,俗称交换器,用于在线程之间交换数据,但是比较受限,因为只能两个线程之间交换数据