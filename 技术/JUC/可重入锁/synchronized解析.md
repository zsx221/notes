说说synchronized底层原理是什么？

    对于synchronized底层的原理，是跟jvm指令和monitor有关系的
        再底层编译后的jvm指令中，会有monitorenter和monitorexit两个指令
            会有monitorenter和monitorexit两个指令
            monitorenter
    monitorexit
    那么monitorenter指令执行的时候会干什么呢?
    每个对象都有一个关联的monitor，比如一个对象实例就有一个monitor，一个类的Class对象也有一个monitor
    如果要对这个对象加锁,那么必须获取这个对象关联的monitor的 lock锁
    
    他里面的原理和思路大概是这样的,monitor里面有一个计数器，
    从О开始的。如果一个线程要获取monitor的锁,就看看他的计数器是不是0,如果是0的话,那么说明没人获取锁，他就可以获取锁了，然后对计数器加1
    
    接着如果出了synchronized修饰的代码片段的范围，就会有一个monitorexit 的指令，在底层。此时获取锁的线程就会对那个对象的monitor的计数器减1
    如果有多次重入加锁就会对应多次减1，直到最后，计数器是O


        