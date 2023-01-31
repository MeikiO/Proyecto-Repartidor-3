package edu.mondragon.mikel_murua.proyecto_repartidor3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;

@SpringBootTest
class ProyectoRepartidor3ApplicationTests {

	@Autowired
	Poblacion_Repository poblacion;
	
	@Autowired
	UserAccount_Repository usserAcount;
	
	
	@Test
	void testDataPoblacion() {
		
		System.out.println("Start data");
	
		long count =this.poblacion.count();
		System.out.println("Elements: "+count);
		
		this.poblacion.findAll().forEach(System.out::println);
		
		System.out.println("End Data");
		
	}
	
	@Test
	void testDataUserAccount() {
		
		System.out.println("Start data");
	
		long count =this.usserAcount.count();
		System.out.println("Elements: "+count);
		
		this.usserAcount.findAll().forEach(System.out::println);
		
		System.out.println("End Data");
		
	}

}
