package com.labs.clinica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.clinica.entity.Usuario;
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

}
