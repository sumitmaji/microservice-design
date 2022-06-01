package com.sum.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This security configuration is applied for any api having oauth2 in the url.
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class OAuth0WebSecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .antMatchers("/**/oauth2/**", "/welcome")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/welcome").authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout()
                .logoutSuccessUrl("/oauth2/token")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID");

        return http.build();
    }

}
