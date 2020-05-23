package com.labs.clinica;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.labs.clinica.envio.Mailer;
import com.labs.clinica.envio.Mensagem;


@SpringBootApplication
public class ClinicaApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
		
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//				ClinicaApplication.class.getPackage().getName());
//		
//		Mailer mailer = applicationContext.getBean(Mailer.class);
//		mailer.enviar(new Mensagem("Alexandre Teste <lariissa.msantoss@gmail.com>", 
//				Arrays.asList("Testes AlgaWorks <lariissa.msantoss@gmail.com>")
//				, "Aula Spring E-mail", "Olá! \n\n O envio de e-mail deu certo!"));
//		
//		applicationContext.close();
//		
//		System.out.println("Fim!");
	
	}

}
