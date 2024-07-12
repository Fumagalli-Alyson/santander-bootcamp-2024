package me.dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class ItemBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String numero;
	@Column(scale = 13, precision = 2)
	private BigDecimal limite;
}
