package br.com.bruno.produtos.apiProdutos.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.bruno.produtos.apiProdutos.modelos.Produto;

public class ProdutoDTO implements Serializable{
	
	private static final long serialVersionUID = 0L;

	private long id;
	private String nome;
	private BigDecimal preco;
	
	public ProdutoDTO() {

	}
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
