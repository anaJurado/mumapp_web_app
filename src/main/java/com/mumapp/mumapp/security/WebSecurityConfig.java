package com.mumapp.mumapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthProvider userRepoAuthProvider;

/*  // FOR TESTING WITH POSTMAN
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http       //other configure params.
                .csrf().disable();
    }

*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();


        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/profile").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers("/dashboard").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");

        http.authorizeRequests().antMatchers("/newUser").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/deleteUser/{id}").hasAnyRole("ADMIN");

        http.authorizeRequests().antMatchers("/saveUser").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers("/user/{id}").hasAnyRole("ADMIN", "USER");

        http.authorizeRequests().antMatchers("/newMusic").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/deleteMusic/{id}").hasAnyRole("ADMIN");

        http.authorizeRequests().antMatchers("/saveMusic").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers("/music/{id}").hasAnyRole("ADMIN", "USER");
        
        http.authorizeRequests().antMatchers("/newCity").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/deleteCity/{id}").hasAnyRole("ADMIN");

        http.authorizeRequests().antMatchers("/saveCity").hasAnyRole("ADMIN", "USER");
        http.authorizeRequests().antMatchers("/city/{id}").hasAnyRole("ADMIN", "USER");


        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/dashboard");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Database authentication provider
        auth.authenticationProvider(userRepoAuthProvider);
    }
}