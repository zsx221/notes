    Minor GC、Major GC、Full GC的触发时机
      1、Minor GC
        当年轻代空间不足时，就会触发Minor GC,这里的年轻代满指的是Eden满，Survivor满不会触发GC。
            (每次Minor GC 会清理年轻代的内存)
        因为Java对象大多都具备朝生熄灭的特性，所以Minor GC非常频繁，一般回收速度也比较快。
            Minor GC会引发STW，暂停其他用户的线程，等垃圾回收结束，用户线程才恢复运行。
      2、Major GC
        出现major gc经常伴随至少一次的Minor GC(但非绝对的，在Paraller Scavenge 收集器的收集策略中就有直接进行Major GC的策略选择过程)
        也就是说在老年代空间不足时，会先尝试触发Minor GC，如果之后空间还不足，会触发Major GC。
        Maror GC的速度一般会比Minor GC慢10倍以上，STW的时间更长。
        如果Major GC后，内存还不足，就会报OOM.
      3、Full GC
        全局gc包括年轻代、老年代、元空间的gc
        调用System.gc()时。系统建议执行Full GC，但是不必然执行
        老年代空间不足
        方法区空间不足
        通过Minor GC后进入老年代的平均大小大于老年代的可用内存
        由Eden区，幸存者0区向幸存者1区复制时，对象大小大于1区可用内存，则把该对象转存到老年代，且老年代的可用内存大小小于该对象大小。
        注意：full GC是开发或调优中尽量要避免的，这样STW会短一些
