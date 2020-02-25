package admin.portal.configuration;

import admin.portal.models.BasicAuthenticationEntryPoint;
import admin.portal.user.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserService userService;

    private BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors().disable()
                .csrf().disable()
                .userDetailsService(this.userService)
                .httpBasic()
                     .authenticationEntryPoint()
                .and();
    }


}
