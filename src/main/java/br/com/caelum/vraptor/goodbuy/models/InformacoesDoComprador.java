package br.com.caelum.vraptor.goodbuy.models;

import java.io.Serializable;

public class InformacoesDoComprador implements Serializable{

	private String numeroDoCartao;
	private String enderecoDeEntrega;	

	public InformacoesDoComprador() {
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(String numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public String getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(String enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	@Override
	public String toString() {
		return "InformacoesDoComprador [numeroDoCartao=" + numeroDoCartao
				+ ", enderecoDeEntrega=" + enderecoDeEntrega + "]";
	}
	
	

}

