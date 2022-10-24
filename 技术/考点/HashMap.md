1、为什么在Java面试中一定会深入考察HashMap?
    答：
        1、在平常的工作中，对数据结构和一些逻辑的掌握是有必要的
        2、而且hashmap中包括了经典的数据结构，数组加链表+红黑树
        3、并且在hashmap中有一些扩容机制和对数据put的处理也比较巧妙，值得我们学习

2、你知道HashMap底层的数据结构是什么吗?
        答：1.8之前是数组加链表，1.8开始就使用数组加链表+红黑树。

3、你知道HashMap是如何解决hash碰撞问题的吗?
        答：其实除hashMap之外的散列表，处理hash碰撞问题是比较常见的，比较常见的有链表法、再hash法、开放地址法

4、说说HashMap是如何进行扩容的可以吗?
        答：
        hashmap的扩容通过几个条件触发
            1、table的元素达到阈值
            2、table为空，需要重新初始化了
        扩容：分几种情况
            确定容量
                1、需要初始化的，设置为16
                2、触发阈值：
                    1)如果old table的元素达到了max Cap，就设置阈值为max Cap
                    2)如果old table的元素*2没到max Cap，就设置new table容量为old cap * 2.
            创建新的数组
                开始搬运数据，把旧table搬到新table。
5、说说TreeMap 和LinkedHashMap 的实现原理?