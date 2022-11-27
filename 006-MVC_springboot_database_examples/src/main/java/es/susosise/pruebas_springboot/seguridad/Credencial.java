package es.susosise.pruebas_springboot.seguridad;

import es.susosise.pruebas_springboot.seguridad.DataMapperDeCredenciales.Rol;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Entity
@Table(name = "credenciales")
public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInterno;
    
    private boolean estaActiva;
    private String nombreDeUsuario;
    private String contraseña;
    private ArrayList<Rol> rolesAsignados;


    public Credencial() {
        rolesAsignados = new ArrayList<>();
    }
    
    public Credencial(Long idInterno, boolean estaActiva, String nombreDeUsuario, String contraseña, ArrayList<Rol> rolesAsignados) {
        this.idInterno = idInterno;
        this.estaActiva = estaActiva;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
        this.rolesAsignados = rolesAsignados;
    }


    public Long getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }

    // este getter es para Spring
    public boolean isEstaActiva() {
        return estaActiva;
    }
    // este getter es para uso interno nuestro
    public boolean estaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombre) {
        this.nombreDeUsuario = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = new BCryptPasswordEncoder().encode(contraseña);
    }

    public List<Rol> getRolesAsignados() {
        return rolesAsignados;
    }

    public void setRolesAsignados(ArrayList<Rol> roles) {
        this.rolesAsignados = roles;
    }
    
    public int getCantidadDeRolesQueTieneAsignados() {
        return rolesAsignados.size();
    }
    
    public void asignarleUnRol(Rol rol) {
        if(!rolesAsignados.contains(rol)) {
            rolesAsignados.add(rol);
        }
    }
    
    public void retirarleUnRol(Rol rol) {
        rolesAsignados.remove(rol);
    }
    
 

}
