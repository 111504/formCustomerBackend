package formCustomer.demo.config;

import formCustomer.demo.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/*"); // 设置过滤器应用的URL模式
        registrationBean.setOrder(1); // 确保顺序足够高，使其在其他过滤器和控制器之前执行
        return registrationBean;
    }
}
