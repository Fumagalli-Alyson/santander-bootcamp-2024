package me.dio.domain.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Usuario;
import me.dio.domain.repository.UsuarioRepository;
import me.dio.domain.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Usuario create(Usuario usuario) {
		if (usuarioRepository.existsByContaNumero(usuario.getConta().getNumero()))
			throw new IllegalArgumentException("Esse Número de Conta já existe.");
		return usuarioRepository.save(usuario);
	}

}
