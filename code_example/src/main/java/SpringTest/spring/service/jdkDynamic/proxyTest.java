package SpringTest.spring.service.jdkDynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class proxyTest implements InvocationHandler {
    private  Object object;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强对象之前的输出
        log.info("增强之前的输出");
        //执行被增强的方法
        Object res=method.invoke(object,args);
        //增强对象之后的输出
        log.info("执行方法打印一遍");
        return res;
    }
    public Object bind (Object object){
        this.object=object;
        /**
         *
         *    public static Object newProxyInstance
         *    (
         *    lassLoader loader,
         *    Class<?>[] interfaces,
         *    InvocationHandler h
         *    )
         *    newProxyInstance，
         *    方法有三个参数：
         *    loader: 用哪个类加载器去加载代理对象
         *    interfaces:动态代理类需要实现的接口
         *    h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        proxyTest jdk=new proxyTest();
        helloword helloword=new Hellowordiml();
        helloword bind = (helloword) jdk.bind(helloword);
        bind.sayhello();
    }
}
