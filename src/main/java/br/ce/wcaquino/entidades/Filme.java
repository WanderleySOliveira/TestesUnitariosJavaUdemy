package br.ce.wcaquino.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Filme {

	private String nome;
	private Integer estoque;
	private Double precoLocacao;  

//	public Filme() {}
//
//	public Filme(String nome, Integer estoque, Double precoLocacao) {
//		this.nome = nome;
//		this.estoque = estoque;
//		this.precoLocacao = precoLocacao;
//	}
}