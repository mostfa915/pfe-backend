package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class Configuration1 extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource ;
@Autowired
    public void GlobalConfig (AuthenticationManagerBuilder ath)throws Exception{
    //ath.inMemoryAuthentication().withUser("admin").password("0000").roles("Admin","user");

  PasswordEncoder passwordEncoder =passwordEncoder() ;
   /*
    System.out.println("mdddp crypté "+passwordEncoder.encode("1111"));


    ath.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1111")).roles("user");

    ath.inMemoryAuthentication().withUser("admin2").password(passwordEncoder.encode("0000")).roles("ADMIN");
*/
   ath.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal ,password as credentials , active from users  where username=?")
           .authoritiesByUsernameQuery("select username as principal , role as role from user_role where username=?").passwordEncoder(passwordEncoder);
}
@Override
public void configure(HttpSecurity http) throws Exception{
    http.formLogin();
    http.authorizeRequests().antMatchers(HttpMethod.GET,"/etudiant**/all**").
            hasRole("ADMIN").and()
    .authorizeRequests().anyRequest().authenticated();
    //desactive le mecanisme de parade contre les attaques de types csrf ,,, la  session est gerer par un token
    http.csrf().disable();
}
 @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
