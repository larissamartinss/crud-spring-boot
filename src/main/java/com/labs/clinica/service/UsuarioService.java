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
	private UsuarioRepository repository;

	public Iterable<Usuario> obterTodos() {

		Iterable<Usuario> Usuario = repository.findAll();
		return Usuario;

	}

	public void salvar(Usuario Usuario) {
		repository.save(Usuario);
	}

	public void enviarEmail(Usuario usuario) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ClinicaApplication.class.getPackage().getName());

		String destinatario = String.format("teste <%s>", usuario.getEmail());
		String assunto = "Clinica online inforrma - O cadastro foi realizado em nossa base";
		String corpo = String.format("Olá %s! \n\n O seu cadastro foi realizado, em nossa base, vamos manter contato!",
				usuario.getNome());

		Mailer mailer = applicationContext.getBean(Mailer.class);
		mailer.enviar(new Mensagem("Clinica Online <contato.teste2000@gmail.com>", Arrays.asList(destinatario), assunto,
				corpo));

		applicationContext.close();
	}

}
