聊聊对CAS的理解以及其底层实现原理？
    
     取值，询问，修改
        多个线程他们可能要访问同一个数据
        HashMap map = new HashMap();
        此时有多个线程要同时读写类似上面的这种内存里的数据，此时必然出现多线程的并发安全问题，几个月培训班的同学，都应该知道
        我们可能要用到并发包下面的很多技术, synchronized
        
        CAS:compare and set 
    ![](E:\Pictures\java_learn\CAS\CAS_Expretition.png)
