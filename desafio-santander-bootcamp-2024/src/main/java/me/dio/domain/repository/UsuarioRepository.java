package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{}
