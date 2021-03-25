package br.com.bruno.produtos.apiProdutos.modelos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 0L;
	
	@Id
	/**
	 * Atraves dessa anotation o banco vai gerar automaticamente os id's, ou seja
	 * nao sera necessario enviar uma requisicao passando um id
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	public Produto() {

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
