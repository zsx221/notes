package SpringTest.spring.service.ioc.iml;

import SpringTest.spring.service.ioc.MyService;
import org.springframework.stereotype.Service;

@Service
public class HappyServiceIml implements MyService {
    @Override
    public void hit() {
        System.out.println("开心的叫");
    }
}
