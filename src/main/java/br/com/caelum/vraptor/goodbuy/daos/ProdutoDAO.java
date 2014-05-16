package br.com.caelum.vraptor.goodbuy.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.vraptor.goodbuy.models.Produto;

public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Produto> lista() {
		return manager.createQuery("select p from Produto p",Produto.class).getResultList();
	}
	
	
}
