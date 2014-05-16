package br.com.caelum.vraptor.goodbuy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class Carrinho implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3247589140522700560L;

	private List<Item> itens = new ArrayList<Item>();

	private Double total = 0.0;

	public void adiciona(Item item) {
		itens.add(item);
		total += item.getProduto().getPreco().doubleValue()
				* item.getQuantidade();
	}

	public Integer getTotalDeItens() {
		return itens.size();
	}

	public Double getTotal() {
		return total;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void remove(int indiceItem) {
		Item removido = itens.remove(indiceItem);
		total -= removido.getProduto().getPreco().doubleValue() * removido.getQuantidade();
	}

}
