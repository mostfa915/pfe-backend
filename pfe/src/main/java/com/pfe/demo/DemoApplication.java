package com.pfe.demo;

import com.pfe.demo.entiter.Artisan;
import com.pfe.demo.entiter.Pannier;
import com.pfe.demo.entiter.Produit;
import com.pfe.demo.entiter.ProduitEvennement;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}

	@Bean
	public BCryptPasswordEncoder getBPE(){
		return new BCryptPasswordEncoder() ;
	}
}
