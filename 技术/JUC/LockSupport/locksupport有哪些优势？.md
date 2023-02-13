    为什么要用lock support呢？它有哪些优势呢？
    1、传统的Object，Condition类中的wait/notify，await/signal
        必须在Synchronized中执行/或者处于lock()和unlock()中。。
        且wait/await必须在notify/signal被执行，不然线程无法被唤醒。
    2、LockSupport的优势：
        1）它可以不在Synchronized的代码块中或者lock(),unlock()中执行。
        2)它根据许可证来阻塞或者唤醒，默认值为0，0为不可用，1为可用。
            这决定了初始时候，如果你先park，它会是-1，而是会是阻塞状态，
               连续
               等待唤醒，同样，如果你先unpark()，它会唤醒，如果连续两次
               使用unpark()也不会增加两个通行证.
