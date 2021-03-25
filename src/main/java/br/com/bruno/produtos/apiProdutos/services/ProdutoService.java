package br.com.bruno.produtos.apiProdutos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.bruno.produtos.apiProdutos.modelos.Produto;
import br.com.bruno.produtos.apiProdutos.repositorio.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	private Produto produto;
	
	DataIntegrityViolationException dataIntegrityViolationException;
	
	public Produto validarProdutoPorId(long id) throws ObjectNotFoundException {
		produto = produtoRepository.findById(id);
		if (produto == null) {
			throw new ObjectNotFoundException(
					"Produto nao encontrado! ID:" 
					+ id
					+ ResponseEntity.status(HttpStatus.NOT_FOUND)
					+ ", Tipo: " 
					+ Produto.class.getName());
		}
		return produto;
	}
	
	public Produto validarProduto(Produto produto) throws ObjectNotFoundException {
		Produto produto1 = (Produto) produtoRepository.findAll();
		if (produto1 == null) {
			throw new ObjectNotFoundException(
					"Lista vazia! "
					+ ", Tipo: "
					+ Produto.class.getName());
		}
		return produto1;
	}
	
	public Produto validarProdutoPost(Produto produtoPost) throws Exception {
		Produto produto1 = (Produto) produtoRepository.findAll();
		if (produto1 == produtoPost) {
			throw new ObjectNotFoundException(
					"Objeto ja existe! "
					+ ResponseEntity.status(HttpStatus.BAD_REQUEST)
					+ ", Tipo: "
					+ Produto.class.getName());
		}
		return produto1;
	}
}
