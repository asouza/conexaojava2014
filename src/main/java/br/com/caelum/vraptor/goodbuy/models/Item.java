package br.com.caelum.vraptor.goodbuy.models;

public class Item {

	private Produto produto;

	private Integer quantidade;
	// getters e setters

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
