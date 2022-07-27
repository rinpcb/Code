package vn.com.spingboot_review_phim.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vn.com.spingboot_review_phim.Interceptor.AuthorizatuionInterceptor;

@Configuration
public class AuthorizatuionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizatuionInterceptor()).addPathPatterns("/call-api/**");
    }
}
