package com.pfe.demo.securité;

import com.pfe.demo.Services.UserdetailServiceImplimentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserdetailServiceImplimentation userDetailservice;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("ADMIN","USER").and()
                .withUser("user").password("1234").roles("USER");
    */
        auth.userDetailsService(userDetailservice).
                passwordEncoder(passwordEncoder);

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    protected void configure(HttpSecurity http) throws Exception {
        // http.formLogin();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/pannier/**","/notificationDetails/**","/icccapp/**","/connectToSocket/**","/sendMail/**","/admin/**","/Discussion/**","/Message/**","/commentaire/**","/emplacement/**","/client/**","/commande/**","/evennement/**","/addroles/", "/artisan/**", "/utilisateur/**", "/register/**", "/tasks/savetask/**", "/addroles/**", "/fournisseur/**", "/client/**", "/produit/**").permitAll();
     /*   http.authorizeRequests().antMatchers(HttpMethod.GET, "/produit/**").hasAnyAuthority("ADMIN");*/
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        //http.addFilter(new JwtAuthetificationFilter(authenticationManager()));
        http.addFilterBefore(new JwtAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter will ignore the below paths
        web.ignoring().antMatchers(
                HttpMethod.POST,
                "/utilisateur/login"
        );
        web.ignoring().antMatchers(

                "/notificationDetails/**",
                "/notificationDetails/",
                "/assetData/",
                "/connectToSocket"
        );
}

}
