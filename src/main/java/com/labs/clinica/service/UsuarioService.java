package com.labs.clinica.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.labs.clinica.ClinicaApplication;
import com.labs.clinica.entity.Usuario;
import com.labs.clinica.envio.Mailer;
import com.labs.clinica.envio.Mensagem;
import com.labs.clinica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private static UsuarioRepository repository;

	public Iterable<Usuario> obterTodos() {

		Iterable<Usuario> Usuario = repository.findAll();
		return Usuario;

	}

	public static Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}
//	public void salvarAlterações(Usuario usuario) {
//		UsuarioService.salvar(usuario);
//	}

	public void enviarEmail(Usuario usuario, Boolean reenvairEmail) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ClinicaApplication.class.getPackage().getName());
		
		String destinatario;
		String assunto;
		String corpo;	
		
		if(reenvairEmail) {
			destinatario = String.format("%s <%s>", usuario.getNome(), usuario.getEmail());
			assunto = "Clinica online informa - cadastro editado";
			corpo = String.format("Olá %s! \n\n O seu cadastro foi editado, em nossa base, vamos continuar mantendo o contato!",
					usuario.getNome());
		}else {
			destinatario = String.format("%s <%s>", usuario.getNome(), usuario.getEmail());
			assunto = "Clinica online informa - O cadastro foi realizado em nossa base";
			corpo = String.format("Olá %s! \n\n O seu cadastro foi realizado, em nossa base, vamos manter contato!",
					usuario.getNome());
		}


		Mailer mailer = applicationContext.getBean(Mailer.class);
		mailer.enviar(new Mensagem("Clinica Online <contato.teste2000@gmail.com>", Arrays.asList(destinatario), assunto,
				corpo));
		


		applicationContext.close();

	}
}
