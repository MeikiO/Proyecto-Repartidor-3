package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_thimeleaf;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class ThymeleafConfiguration {
	@Bean
	public LayoutDialect layoutDialect() {
	  return new LayoutDialect();
	}
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect());
        return engine;
    }

}