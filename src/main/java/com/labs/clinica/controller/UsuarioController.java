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
import com.labs.clinica.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	@Autowired
	private UsuarioRepository UsuarioRepository;

	@Autowired
	private UsuarioService UsuarioService;

	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long UsuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não cadastrado: " + UsuarioId));
		return ResponseEntity.ok().body(usuario);
	}

	@GetMapping("/usuarios/validacpf/{cpf}")
	public ResponseEntity<Boolean> getUsuarioByCpf(@PathVariable(value = "cpf") String usuarioCpf)
			throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findByCPF(usuarioCpf);
		if (usuario != null) {
			return ResponseEntity.ok().body(false);
		}
		return ResponseEntity.ok().body(true);
	}

	@PostMapping("/usuarios")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) throws ResourceNotFoundException {

		Usuario usuarioBanco = UsuarioRepository.findByCPF(usuario.getCpf());

		if (usuarioBanco != null) {
			throw new ResourceNotFoundException("CPF já existente na base");
		} else {
			usuario.setData(new Date());

			Usuario usuarioSalvo = UsuarioRepository.save(usuario);
			if (usuario.getIsManterContato()) {
				UsuarioService.enviarEmail(usuario,false);
			}

			return usuarioSalvo;
		}
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long UsuarioId,
			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
		Usuario usuario = UsuarioRepository.findById(UsuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontradao para o id :: " + UsuarioId));

		usuario.setId(usuarioDetails.getId());
		usuario.setNome(usuarioDetails.getNome());
		usuario.setResidencial(usuarioDetails.getResidencial());
		usuario.setWhatsApp(usuarioDetails.getWhatsApp());
		usuario.setComercial(usuarioDetails.getComercial());
		usuario.setCelular1(usuarioDetails.getCelular1());
		usuario.setCelular2(usuarioDetails.getCelular2());
		usuario.setCelular3(usuarioDetails.getCelular3());
		usuario.setCelular4(usuarioDetails.getCelular4());
		usuario.setCelular5(usuarioDetails.getCelular5());
		usuario.setBairro(usuarioDetails.getBairro());
		usuario.setCep(usuarioDetails.getCep());
		usuario.setLocalidade(usuarioDetails.getLocalidade());
		usuario.setComplemento(usuarioDetails.getComplemento());
		usuario.setUf(usuarioDetails.getUf());
		usuario.setLogradouro(usuarioDetails.getLogradouro());
		usuario.setNumero(usuarioDetails.getNumero());
		usuario.setData(new Date());

		if (!usuario.getCpf().equals(usuarioDetails.getCpf())) {
			usuario.setCpf(usuarioDetails.getCpf());
			Usuario usuarioBanco = UsuarioRepository.findByCPF(usuario.getCpf());
			if (usuarioBanco != null) {
				throw new ResourceNotFoundException("CPF já existente na base");
			}
		}
//		final Usuario updatedUsuario = UsuarioRepository.save(usuario);
		
		Usuario usuarioSalvo = UsuarioRepository.save(usuario);
		if(usuario.getIsManterContato()) {
			UsuarioService.enviarEmail(usuario, true);
			
		}
		return ResponseEntity.ok(usuarioSalvo);

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