package me.dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity(name = "tb_cartoes")
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String numero;
	@Column(scale = 13, precision = 2)
	private BigDecimal limite;
}
