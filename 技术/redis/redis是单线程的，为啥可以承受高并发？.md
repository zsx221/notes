    Redis的高并发和快速原因
        1.redis是基于内存的，内存的读写速度非常快；
        
        2.redis是单线程的，省去了很多上下文切换线程的时间；
        
        3.redis使用多路复用技术，可以处理并发的连接。非阻塞IO 内部实现采用epoll，采用了epoll+自己实现的简单的事件框架。
            epoll中的读、写、关闭、连接都转化成了事件，然后利用epoll的多路复用特性，绝不在io上浪费一点时间。
        Redis采用了IO多路复用机制，使其在网络IO操作中能并发处理大量的客户端请求，实现高吞吐率。
        多路复用：多路指的是多个socket网络连接，复用指的是一个线程。
     Redis在持久化时fork出一个子进程，这时已经有两个进程了，怎么能说是单线程呢？
        Redis是单线程的，主要是指Redis的网络IO和键值对读写是由一个线程来完成的。而Redis的其他功能，如持久化、异步删除、集群数据同步等
            则是依赖其他线程来执行的。所以，说Redis是单线程的只是一种习惯的说法，事实上它的底层不是单线程的。

        set和zset有什么区别？
            一个无序一个有序
        说一下Redis中的watch命令
            很多时候，要确保事务中的数据没有被其他客户端修改才执行该事务。Redis提供了watch命令来解决这类问题，这是一种乐观锁的机制。
                客户端通过watch命令，要求服务器对一个或多个key进行监视，如果在客户端执行事务之前，这些key发生了变化，则服务器将拒绝执行客户端提交的事务，并向它返回一个空值。
            

    
    为什么Redis是单线程的?
        优势：
            因为redis是基于内存的操作，cpu不是redis的瓶颈，redis的瓶颈只会是机器的内存大小和网络带宽，既然单线程容易，而且cpu
                不会成为瓶颈，那就顺理成章采用单线程的方案。
            在单线程的情况下，就不用去考虑各种锁的问题，不存在加锁释放锁操作，没有因为可能出现死锁而导致的性能消耗。
            采用单线程，避免了不必要的上下文切换和竞争条件，也不存在多进程或者多线程导致的切换而消耗 CPU。
            Redis全程使用hash结构，读取速度快
        劣势：
            无法发挥多核CPU性能，不过可以通过在单机开多个Redis实例来完善。

    Redis是内存数据库，宕机后数据会消失，Redis重启后快速恢复数据，要提供持久化机制。
    Redis的两种持久化方式：RDB和AOF
       Redis持久化不保证数据的完整性，有可能会丢数据。当Redis用作DB时，DB数据要完整，所以一定要有一个完整的数据源（文件、mysql）
        在系统启动时，从这个完整的数据源中将数据load到Redis中。
    
    RDB方式
    RDB（Redis DataBase），是redis默认的存储方式，RDB方式是通过快照（ snapshotting ）完成的。
            它保存的是某一时刻的数据并不关注过程。RDB保存redis某一时刻的数据的快照
        触发快照的方式
          1. 符合自定义配置的快照规则；
          2. 执行save或者bgsave命令；
          3. 执行flushall命令；
          4. 执行主从复制操作 (第一次)。
        RDB执行流程（原理）
            1. Redis父进程首先判断：当前是否在执行save，或bgsave/bgrewriteaof（aof文件重写命令）的子进程，如果在执行则bgsave命令直接返回；
    
            2. 父进程执行fork（调用OS函数复制主进程）操作创建子进程，这个过程中父进程是阻塞的，Redis不能执行来自客户端的任何命令；
    
            3. 父进程fork后，bgsave命令返回”Background saving started”信息并不再阻塞父进程，并可以响应其他命令；
    
            4. 子进程创建RDB文件，根据父进程内存快照生成临时快照文件，完成后对原有文件进行原子替换（RDB始终完整）；
    
            5. 子进程发送信号给父进程表示完成，父进程更新统计信息。
    
            6. 父进程fork子进程后，继续工作。
        RDB的优缺点
        优点
        
        1.RDB是二进制压缩文件，占用空间小，便于传输（传给slaver）；
        2.主进程fork子进程，可以最大化Redis性能；
        3.使用RDB文件来恢复数据较快。
        
        缺点
        
        1、不保证数据完整性，会丢失最后一次快照以后更改的所有数据；
        2、父进程在fork子进程的时候如果主进程比较大会阻塞；
        

        AOF
        AOF（append only file）是Redis的另一种持久化方式。
         Redis默认情况下是不开启的。开启AOF持久化后Redis 将所有对数据库进行过写入的命令（及其参数）（RESP）记录到 AOF 文件，
            以此达到记录数据库状态的目的，这样当Redis重启后只要按顺序回放这些命令就会恢复到原始状态了。AOF会记录过程，RDB只管结果