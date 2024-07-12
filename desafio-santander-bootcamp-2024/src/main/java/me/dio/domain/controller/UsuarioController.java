package me.dio.domain.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Usuario;
import me.dio.domain.service.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
			Usuario usuario = usuarioService.findById(id);
			return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuarioParaCriar) {
		Usuario usuarioCriado = usuarioService.create(usuarioParaCriar);
		URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuarioCriado.getId())
				.toUri();
		return ResponseEntity.created(localizacao).body(usuarioCriado);
	}
}
