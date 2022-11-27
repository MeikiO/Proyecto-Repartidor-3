package es.susosise.pruebas_springboot.seguridad;

import org.springframework.stereotype.Service;

import es.susosise.pruebas_springboot.App;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private Credenciales credenciales;
    
    public MyUserDetailsService(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  
        // Se trata de determinar si alguien que clama ser "username" puede o no entrar a la aplicación
        // ==> si puede: se han de devolver todos sus datos (UserDetails), para que el autentificador (AuthenticationManager) pueda verificarlos
        // ==> si no puede: se ha de devolver una excepcion (UsernameNotFoundException), y el autentificador rechazará la entrada.
        Optional<Credencial> credencial = credenciales.buscarPorNombreDeUsuario(username);
        if (credencial.isPresent()) {
            App.logger.info("{} acaba de iniciar sesión.", credencial.get().getNombreDeUsuario());
            Credencial credencialEncontrada = credencial.get();
            return DataMapperDeCredenciales.pasarDeCredencialAUserServiceDetails(credencialEncontrada);
        } else {
            throw new UsernameNotFoundException("[" + username + "] no está en la lista de autorizados");
        }
    }

    
    //nota: Esto no es necesario, es solo ilustrativo.
    private UserDetails trucoParaPruebasManuales(String username) {
        switch (username) {
            case "Benganito":
                String contraseña01 = new BCryptPasswordEncoder().encode("zaqwsx");
                ArrayList<GrantedAuthority> roles01 = new ArrayList<>();
                roles01.add(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"));
                roles01.add(new SimpleGrantedAuthority("ROLE_REPARTIDOR"));
                return new User(username, contraseña01, roles01);
            case "Fulanito":
                String contraseña02 = new BCryptPasswordEncoder().encode("mko");
                ArrayList<GrantedAuthority> roles02 = new ArrayList<>();
                roles02.add(new SimpleGrantedAuthority("ROLE_REPARTIDOR"));
                return new User(username, contraseña02, roles02);
            case "Zutanito":
                String contraseña03 = new BCryptPasswordEncoder().encode("vfr");
                ArrayList<GrantedAuthority> roles03 = new ArrayList<>();
                roles03.add(new SimpleGrantedAuthority("ROLE_CLIENTE"));
                return new User(username, contraseña03, roles03);
           default:
                throw new UsernameNotFoundException("[" + username + "] no está en la lista de autorizados");
                
        }
    }
    
    //nota: Esto no es necesario para el funcionamiento de esta clase, es solo ilustrativo.
    private void ejemplosDeComoAccederAlCurrentUser() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            
            String nombreDelUsuarioLogeado = auth.getName();
            
            // para usarlo donde deseemos, por ejemplo:
            if (nombreDelUsuarioLogeado.equals("Zutanito")) {
                //hacer algo que le corresponde a Zutanito...
            } else {
                //hacer algo que le corresponde a cualquier otro usuario...
            }
            
            
            ArrayList<GrantedAuthority> rolesDelUsuarioLogeado = (ArrayList<GrantedAuthority>) auth.getAuthorities();
            
            // para usarlo donde deseemos, por ejemplo:
            if (rolesDelUsuarioLogeado.contains(new SimpleGrantedAuthority("ROLE_CLIENTE"))) {
                //hacer algo que le corresponde a un cliente
            } else {
                //hacer algo que le corresponde a cualquier otro usuario que no sea cliente...
            }
            
        }
    }

}

