package br.com.caelum.vraptor.goodbuy.events;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;

import br.com.caelum.vraptor.goodbuy.models.Compra;

@RequestScoped
public class EnviaEmailFinalDeCompra {
	
	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext context;

	@Resource(lookup = "jms/queue/emails")
	Destination fila;

	public void envia(@Observes Compra compra) {
		ObjectMessage message = context.createObjectMessage(compra);
		context.createProducer().send(fila,message);
	}
}
