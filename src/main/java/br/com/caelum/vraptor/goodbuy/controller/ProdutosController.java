package br.com.caelum.vraptor.goodbuy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.goodbuy.daos.ProdutoDAO;
import br.com.caelum.vraptor.goodbuy.models.Produto;

@Controller
public class ProdutosController {
	
	@PersistenceContext
	private EntityManager manager;
	@Inject
	private ProdutoDAO produtos;
	
	@Get("/produtos/novo")
	public void formulario(){
		
	}
	
	@Transactional
	@Post("/produtos")
	public void adiciona(Produto produto){
		manager.persist(produto);
	}
	
	@Get("/produtos")
	@Transactional
	public List<Produto> lista(){
		return produtos.lista();
	}
}
