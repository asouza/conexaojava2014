package br.com.caelum.vraptor.goodbuy.events;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.goodbuy.models.Compra;

@RequestScoped
public class EnviaEmailFinalDeCompraParaAdmin {

	public void envia(@Observes Compra compra){
		System.out.println("enviando email...");
	}
}
