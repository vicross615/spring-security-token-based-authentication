package admin.portal.configuration;

import admin.portal.models.BasicAuthenticationEntryPoint;
import admin.portal.user.service.UserService;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserService userService;

    private Gson gson;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors().disable()
                .csrf().disable()
                .userDetailsService(this.userService)
                .httpBasic()
                     .authenticationEntryPoint(new BasicAuthenticationEntryPoint(this.gson))
                .and();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "POST", "PUT", "PATCH", "UPDATE", "DELETE", "PATCH");
            }
        };
    }


}
