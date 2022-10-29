package SpringTest.spring.service.ioc.iml;

import SpringTest.spring.service.ioc.MyService;
import org.springframework.stereotype.Service;

@Service("BadServiceIml")
public class BadServiceIml implements MyService {
    @Override
    public void hit() {
        System.out.println("难过的叫哦");
    }
}
