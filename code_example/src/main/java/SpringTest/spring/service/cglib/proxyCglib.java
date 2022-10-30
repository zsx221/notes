package SpringTest.spring.service.cglib;

import SpringTest.spring.service.jdkDynamic.Hellowordiml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
@Slf4j
public class proxyCglib implements MethodInterceptor {
    /**
     * 
     * @param proxy
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method,
                            Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        log.info("方法之前的增强 ");
        Object res=methodProxy.invokeSuper(proxy,objects);
        log.info("方法之后的增强 ");
        return res;
    }
    /**
     *
     * @param cla
     * @return
     */
    public  Object getProxy(Class cla)
    {
       //enhancer 增强类对象
        Enhancer enhancer=new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cla);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args) {
        proxyCglib proxyCglib=new proxyCglib();
        Hellowordiml hellowordiml=(Hellowordiml)proxyCglib.getProxy(Hellowordiml.class);
        hellowordiml.sayhello();
    }
}
