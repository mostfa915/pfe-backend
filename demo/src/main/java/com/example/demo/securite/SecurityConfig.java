 package com.example.demo.securite;
import com.example.demo.service.UserdetailServiceImplimentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private UserdetailServiceImplimentation userDetailservice;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder ;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
       /* auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("ADMIN","USER").and()
                .withUser("user").password("1234").roles("USER");
    */
       auth.userDetailsService(userDetailservice).
       passwordEncoder(passwordEncoder);

    }

    protected  void configure(HttpSecurity http)throws Exception{
        http.formLogin();
     http.authorizeRequests().antMatchers(/*"/login/","/register/**","/tasks/savetask/**"*/).permitAll();
       http.authorizeRequests().antMatchers(HttpMethod.GET,"/tasks/all").hasAnyAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
http.csrf().disable();
    }

   /* @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userDetailservice);
        return daoAuthenticationProvider;
    }
*/

}
