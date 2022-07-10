package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class ServicioDeSeguridad implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO aqui falta buscar el username en la lista de usuarios autorizados
        //      y actuar en consecuencia...
        // Para simplificar... por ahora devolvemos datos fijos... 
        // ...se podra entrar con cualquier username y con password "zaq"
       
    	
    	String nombre = username;
        
    	String contraseña = new BCryptPasswordEncoder().encode("zaq");
        
    	Set<GrantedAuthority> permisos = new HashSet<>();
        permisos.add(new SimpleGrantedAuthority("PUEDEHACERCUALQUIERCOSA"));
        
        return new User(nombre, contraseña, permisos);
    }
    

}
