package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        //.authorizeRequests().antMatchers("/**").permitAll() //con esto quitamos toda la seguridad
           
           .authorizeRequests().antMatchers("/css/**", "/images/**" , "/js/**").permitAll() //esta es para ponerla
           .anyRequest().authenticated()
           .and()
           .formLogin()
           .loginPage("/login")
           .permitAll()
           .and()
           .logout()
           .invalidateHttpSession(true)
           .permitAll();
        return http.build();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new MyUserDetailService()).passwordEncoder(new BCryptPasswordEncoder());
    }
 
}
