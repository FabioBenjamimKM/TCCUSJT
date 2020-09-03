package com.usjt.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableScheduling
@EnableResourceServer
public class AnaliseDeInvestimentoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseDeInvestimentoApplication.class, args);
	}

}
