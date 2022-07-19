package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	CredencialesService service;
	
	@Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO aqui falta buscar el username en la lista de usuarios autorizados
        //      y actuar en consecuencia...
        // Para simplificar... por ahora devolvemos datos fijos... 
        // ...se podra entrar con cualquier username y con password "zaq"
       
    	
    	
		//Credencial user=this.service.buscarPorUsername(username);
    	String nombre=username;
	 	String contrasena = new BCryptPasswordEncoder().encode("zaq");
        
		
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(Roles.ROLE_CLIENTE.name()));
     
        
   //     Credencial user=new Credencial((long)1,true,nombre,contrasena,roles);
   // + Si queremos que nos tome los permisos tenemos que pasarlo en el objeto User definido
   // por springboot, sino nos aparecera como un Object sin casteo y no podremos utilizarlo.
            
        return new User(nombre, contrasena, roles);
    }
    
    
}
