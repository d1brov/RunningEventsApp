package com.portfolio.app.security.configuration;

import com.portfolio.app.security.access.RoleName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity(debug = true)    // todo remove debug mode
public class FilterChainConfiguration {

    @Bean
    public SecurityFilterChain filterChainAllowAll(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and().csrf().disable();

        // open endpoints
        httpSecurity.authorizeRequests()
                .antMatchers(
                        "/registration",
                        "/events/**",
                        "/users/**",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/**/api-docs/**"
                ).permitAll();

        // secure endpoints
        httpSecurity
                .authorizeRequests().antMatchers(GET, "/test/admin").hasRole(RoleName.ADMIN.name())
                .and()
                .authorizeRequests().antMatchers(GET, "/test/user").hasRole(RoleName.USER.name());

        // close rest endpoints
        httpSecurity.authorizeRequests().anyRequest().authenticated();

        // basic authentication
        //httpSecurity.httpBasic();

        return httpSecurity.build();
    }
}