package me.dio.domain.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity(name = "tb_usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	private Conta conta;
	@OneToOne(cascade = CascadeType.ALL)
	private Cartao cartao;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Feature> features;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Noticia> noticias;
	
	
}
