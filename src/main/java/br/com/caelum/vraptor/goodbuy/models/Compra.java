package br.com.caelum.vraptor.goodbuy.models;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class Compra {

	private Carrinho carrinho;
	private InformacoesDoComprador info;

	public Compra(InformacoesDoComprador info, Carrinho carrinho) {
		this.info = info;
		this.carrinho = carrinho;
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	
	public InformacoesDoComprador getInfo() {
		return info;
	}

}
