package SpringTest.spring.controller.aop;

import SpringTest.spring.service.aop.MainConfigOfAOP;
import SpringTest.spring.service.aop.MathCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IOCTest_AOP {
    @RequestMapping("/test01")
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        //1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(2, 2);
        applicationContext.close();
    }
}
