package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
	@Autowired
	UserDetailsService userDetailsService;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception {
       
		http
        //.authorizeRequests().antMatchers("/**").permitAll() //con esto quitamos toda la seguridad
           
           .authorizeRequests().antMatchers("/css/**", "/images/**" , "/js/**").permitAll() //esta es para ponerla
              
           /*
            Limitamos el enlace la funcion del mapping -> /admin/ solo lo pueda acceder los usuarios con el roll ROLE_ADMIN
            
            -> De esta manera tambien limitaremos el de cliente y repartidor.
            
            -> El admin puede acceder a todo hasique lo pondremos en todos.
            
            */
           .antMatchers("/admin/**").hasRole("ADMIN")
           

           // Ejemplo donde se ponen multiples roles:
           //-> https://stackoverflow.com/questions/42910708/authorize-requests-for-multiple-roles-for-different-urls
           
           .antMatchers("/cliente/**")
           .access("hasRole('ADMIN') or hasAuthority('ADMIN') OR hasRole('CLIENTE') or hasAuthority('CLIENTE')")
           
           
           .antMatchers("/repartidor/**")
           .access("hasRole('ADMIN') or hasAuthority('ADMIN') OR hasRole('TRABAJADOR') or hasAuthority('TRABAJADOR')")
           
           
           
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
        auth.userDetailsService(new MyUserDetailService()).
        passwordEncoder(new BCryptPasswordEncoder());
    }

 
}