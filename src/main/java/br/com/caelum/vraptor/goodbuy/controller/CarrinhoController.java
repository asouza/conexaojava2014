package br.com.caelum.vraptor.goodbuy.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.ClientBuilder;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.goodbuy.models.Carrinho;
import br.com.caelum.vraptor.goodbuy.models.Item;
import br.com.caelum.vraptor.goodbuy.models.Produto;

@Controller
public class CarrinhoController {

	@Inject
	private Carrinho carrinho;
	@Inject
	private Result result;
	@PersistenceContext
	private EntityManager manager;

	@Post("/carrinho")
	public void adiciona(Item item) {
		Produto produtoCompleto = manager.find(Produto.class, item.getProduto().getId());
		item.setProduto(produtoCompleto);
		carrinho.adiciona(item);

		result.redirectTo(ProdutosController.class).lista();
	}

	@Get("/carrinho")
	public void visualiza() {
	}

	@Post("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}

}
