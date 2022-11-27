package es.susosise.pruebas_springboot.seguridad;


public class CredencialDTO {
    public Long idInterno;
    
    public boolean estaActiva;
    public String nombreDeUsuario;
    public String contraseña;

    public boolean tieneRolCurrela;
    public boolean tieneRolAdministrador;
    public boolean tieneRolVisitante;
    public Long getIdInterno() {
        return idInterno;
    }
    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }
    public boolean isEstaActiva() {
        return estaActiva;
    }
    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public boolean isTieneRolCurrela() {
        return tieneRolCurrela;
    }
    public void setTieneRolCurrela(boolean tieneRolCurrela) {
        this.tieneRolCurrela = tieneRolCurrela;
    }
    public boolean isTieneRolAdministrador() {
        return tieneRolAdministrador;
    }
    public void setTieneRolAdministrador(boolean tieneRolAdministrador) {
        this.tieneRolAdministrador = tieneRolAdministrador;
    }
    public boolean isTieneRolVisitante() {
        return tieneRolVisitante;
    }
    public void setTieneRolVisitante(boolean tieneRolVisitante) {
        this.tieneRolVisitante = tieneRolVisitante;
    }

    
}
