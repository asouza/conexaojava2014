package br.com.caelum.vraptor.goodbuy.events;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.goodbuy.models.Compra;

@RequestScoped
public class IntegraComOPagamento {

	public void integra(@Observes Compra compra){
		System.out.println("integrar com o meio de pagamento");
	}
}
