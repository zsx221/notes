    
    1、redis高并发跟整个系统的高并发之间的关系
    redis，你要搞高并发的话，不可避免，要把底层的缓存搞得很好
    mysql，高并发，做到了，那么也是通过一系列复杂的分库分表，订单系统，事务要求的，QPS到几万，比较高了要做一些电商的商品详情页，真正的超高并发，QPS上十万
    甚至是百万，一秒钟百万的请求量光是redis是不够的，但是redis是整个大型的缓存架构中，支撑高并发的架构里面，非常重要的一个环节
    享委你的底层的存中间件，存系统，必须能支的起我们说的那种高并发，其次，再经过良好的整体的教存架构的设计(多级存架构、热点存)，支津真正的上十万，甚至上百万的高
    2、redis不能支撑高并发的瓶颈在哪里?   
    单机
    3、如果redis要支撑超过10万+的并发，那应该怎么做?
    单机的redis几乎不太可能说QPS超过10万+，除非一些特殊情况，比如你的机器性能特别好，配置特别高，物理机，护做的特别好，而且你的整体的操作不是太复杂
    单机在几万读写分离，一般来说，对缓存，一般都是用来支撑读高并发的，写的请求是比较少的，可能写请求也就一秒钟几千，一两千大量的请求都是读，一秒钟二十万次读
    读写分离

    4、redis保持高可用的三种方法：主从模式，哨兵模式，集群模式。