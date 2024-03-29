         redis主要是基于内存来进行高性能、高并发的读写操作的。但既然内存是有限的，例如redis就只能使用10G
          你写入了20G。这个时候就需要清理掉10G数据，保留10G数据。那应该保留哪些数据，清除哪些数据，为什么有些数据明明过期了
           怎么还占用着内存？这都是由redis的过期策略来决定的。
        redis的过期策略
            redis的过期策略就是：定期删除 + 惰性删除。

         定期删除，指的是redis默认是每隔100ms就随机抽取一些设置了过期时间的key，检查是否过期，如果过期就删除。
         假设redis里放了10W个key，都设置了过期时间，你每隔几百毫秒就检查全部的key，那redis很有可能就挂了，CPU负载会很高
            都消耗在检查过期的key上。注意，这里不是每隔100ms就遍历所有设置过期时间的key，那样就是一场性能灾难
                实际上redis是每隔100ms就随机抽取一些key来检查和删除的。
         定期删除可能会导致很多过期的key到了时间并没有被删除掉。这个时候就可以用到惰性删除了。惰性删除是指在你获取某个key的时候
            redis会检查一下，这个key如果设置了过期时间并且已经过期了，此时就会删除，不会给你返回任何东西。
         但即使是这样，依旧有问题。如果定期删除漏掉了很多过期的key，然后你也没及时去查，也就没走惰性删除。
            此时依旧有可能大量过期的key堆积在内存里，导致内存耗尽。
         这个时候就需要内存淘汰机制了。
        内存淘汰机制
          redis内存淘汰机制有以下几个：
            noeviction：当内存不足以容纳新写入数据时，新写入操作会报错。这个一般很少用。
            allkeys-lru：当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的key，这个是最常用的。
            allkeys-random：当内存不足以容纳新写入数据时，在键空间中，随机移除某个key。
            volatile-lru：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，移除最近最少使用的key。
            volatile-random：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，随机移除某个key。
            volatile-ttl：当内存不足以容纳新写入数据时，在设置了过期时间的键空间中，有更早过期时间的key优先移除。