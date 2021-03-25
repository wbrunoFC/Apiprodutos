package br.com.bruno.produtos.apiProdutos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import br.com.bruno.produtos.apiProdutos.dto.ProdutoDTO;
import br.com.bruno.produtos.apiProdutos.modelos.*;
import br.com.bruno.produtos.apiProdutos.repositorio.ProdutoRepository;
import br.com.bruno.produtos.apiProdutos.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
/**@CrossOrigin libera qualquer dominio para acessar a api**/
@CrossOrigin(origins = "*")
@Api(value = "API de produtos")
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	@ApiOperation(value = "Lista todos os produtos")
	public List<ProdutoDTO> listarProdutos(){
		List<Produto> list = new ArrayList<>();
		
		produtoService.validarProduto(list);
		
		List<Produto> list = produtoRepository.findAll();
		
		List<ProdutoDTO> listDto = list.stream().map(obj -> 
				new ProdutoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Lista apenas um produto")
	public Produto listarProdutoUnico(@PathVariable(value="id") long id) 
			throws ObjectNotFoundException{
		
		produtoService.validarProdutoPorId(id);
		return produtoRepository.findById(id);
	}
	
	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	@ApiOperation(value = "Cadastra um produto")
	public Produto salvaroduto(@RequestBody Produto produto) throws Exception {
		
		produtoService.validarProdutoPost(produto);
		return produtoRepository.save(produto);
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Apaga um produto")
	public <T> void deletarProduto(@RequestBody @PathVariable(value="id") long id) 
			throws ObjectNotFoundException {
		
		produtoService.validarProdutoPorId(id);
		produtoRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Atualiza um produto")
	public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable(value="id") long id ) 
			throws ObjectNotFoundException {
		
		produtoService.validarProdutoPorId(id);
		return produtoRepository.save(produto);
	}
}
