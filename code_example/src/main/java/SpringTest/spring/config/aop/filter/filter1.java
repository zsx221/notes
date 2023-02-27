package SpringTest.spring.config.aop.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
@Component
public class filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("filter1 init");
    }

    @Override
    public void destroy() {
        System.out.println("filter1 destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器进入方法前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器进入方法后");
    }
}
