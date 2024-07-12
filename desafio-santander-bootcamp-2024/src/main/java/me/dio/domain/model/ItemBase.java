package me.dio.domain.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class ItemBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String icon;
	private String descricao;
}
