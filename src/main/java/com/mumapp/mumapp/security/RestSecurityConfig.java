package com.mumapp.mumapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthProvider userRepoAuthProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/api/**");


        // LOGIN LOGOUT
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/login").authenticated();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logout").authenticated();
        // USER
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/all").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/{id}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/{id}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/user/{id}").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/{id}/city").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/{id}/music").hasAnyRole("ADMIN", "USER");
        // MUSIC
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/music/all/style").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/music/all/id").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/music/{id}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/music/style/{style}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/music").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/music/{id}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/music/{id}").hasAnyRole("ADMIN");
        // CITY
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/city/all").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/city/all/name").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/city/all/id").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/city/{id}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/city/name/{name}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/city").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/city/{id}").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/city/{id}").hasAnyRole("ADMIN");
        // POPULARITY
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/world/popularity/pagination").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/{id}/popularity/pagination").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/popularity").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/popularity/top").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/{id}/popularity").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/{id}/popularity/top").hasAnyRole("ADMIN", "USER");
        // GENERATE DATA
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/generate_data").hasAnyRole("ADMIN", "USER");


        // Other URLs can be accessed without authentication
        http.authorizeRequests().anyRequest().permitAll();

        // Disable CSRF protection (it is difficult to implement in REST APIs)
        http.csrf().disable();

        // Use Http Basic Authentication
        http.httpBasic();

        // Do not redirect when logout
        http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Database authentication provider
        auth.authenticationProvider(userRepoAuthProvider);
    }

}
