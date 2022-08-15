package edu.mondragon.mikel_murua.proyecto_repartidor3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;

public class TestDatabases {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("springpruebas");
    EntityManager em = emf.createEntityManager();
    
	public TestDatabases() {
	}
	
	@Test
    @Transactional
    @Rollback(false)
    public void check_sql_statement_when_persisting_in_one_to_one_bidirectional() {
 
        PuntoReparto_Pojo student = new PuntoReparto_Pojo();
        student.setApellidos_cliente("hay");
        student.setId((long)1);
                
        Poblacion_Pojo tuition = new Poblacion_Pojo();
        tuition.setRegion("Guipuzkoa");
        tuition.setNombreLocalizacion("Arrasate");
        tuition.setCodigoPostal("20500");
        
        
        student.setPoblacion(tuition);
 
        em.persist(student);
    }
	
	
}
