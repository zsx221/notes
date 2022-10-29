package SpringTest.spring.controller.ioc;

import SpringTest.spring.service.ioc.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class myController {
    @Resource(name ="BadServiceIml" )
    MyService myService;
    @RequestMapping("/")
    public void doPost(){
        myService.hit();
    }
}
