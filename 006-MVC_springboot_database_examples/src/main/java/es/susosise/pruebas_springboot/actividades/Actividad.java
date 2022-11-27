package es.susosise.pruebas_springboot.actividades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import es.susosise.pruebas_springboot.personas.Persona;

@Entity
@Table(name = "actividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actividadId")
    private Long idInterno;

    private String titulo;
    private String descripcion;
    private String dia;
    private String hora;
    private String lugarDePartida;
    
    @ManyToMany(mappedBy="actividades")
    private Set<Persona> participantes;

    
    public Actividad() {
    }

    public Actividad(Long idInterno, String titulo, String descripcion, String dia, String hora, String lugarDePartida, Set<Persona> participantes) {
        this.idInterno = idInterno;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dia = dia;
        this.hora = hora;
        this.lugarDePartida = lugarDePartida;
        this.participantes = participantes;
    }

    public Long getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugarDePartida() {
        return lugarDePartida;
    }

    public void setLugarDePartida(String lugarDePartida) {
        this.lugarDePartida = lugarDePartida;
    }

    public Set<Persona> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Persona> participantes) {
        this.participantes = participantes;
    }

    
}
