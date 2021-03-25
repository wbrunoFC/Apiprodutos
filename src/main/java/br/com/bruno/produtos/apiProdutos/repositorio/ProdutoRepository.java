package br.com.bruno.produtos.apiProdutos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.produtos.apiProdutos.modelos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Produto findById(long id);
}
