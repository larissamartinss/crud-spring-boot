package com.labs.clinica.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.clinica.entity.Usuario;
import com.labs.clinica.exception.ResourceNotFoundException;
import com.labs.clinica.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	@Autowired
	private UsuarioRepository UsuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long UsuarioId)
			throws ResourceNotFoundException {
		Usuario Usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não cadastrado: " + UsuarioId));
		return ResponseEntity.ok().body(Usuario);
	}

	@PostMapping("/usuarios")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		usuario.setData(new Date());
		return UsuarioRepository.save(usuario);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long UsuarioId,
			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontradao para o id :: " + UsuarioId));

		usuario.setId(usuarioDetails.getId());
		usuario.setnome(usuarioDetails.getnome());
		usuario.setcpf(usuarioDetails.getcpf());
		usuario.settelefone(usuarioDetails.gettelefone());
		usuario.setData(new Date());
		final Usuario updatedUsuario = UsuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}

	@DeleteMapping("/usuarios/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long UsuarioId)
			throws ResourceNotFoundException {
		Usuario Usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontradao para o id :: " + UsuarioId));

		UsuarioRepository.delete(Usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}