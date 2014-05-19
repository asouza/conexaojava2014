package br.com.caelum.vraptor.goodbuy.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.goodbuy.models.Carrinho;
import br.com.caelum.vraptor.goodbuy.models.Compra;
import br.com.caelum.vraptor.goodbuy.models.InformacoesDoComprador;

@ConversationScoped
@Controller
@Named
public class PagamentoController implements Serializable{

	@Inject
	private Conversation conversation;
	@Inject
	private transient Result result;
	private InformacoesDoComprador info = new InformacoesDoComprador();
	@Inject
	private Carrinho carrinho;
	@Inject
	private Event<Compra> finalizador;
	
	public String getConversationId() {
		return conversation.getId();
	}
	
	@Get("compra/endereco")
	public void formularioEndereco(){
		conversation.begin();
		result.include("conversation",conversation);
	}
	
	@Post("compra/endereco")
	public void associaEndereco(String endereco){
		info.setEnderecoDeEntrega(endereco);
		result.redirectTo("/compra/cartao?cid="+conversation.getId());
		
	}
	
	@Get("compra/cartao")
	public void formularioCartao(String cid){
		
	}
	
	@Post("compra/cartao")
	public void associaCartao(String numero){
		info.setNumeroDoCartao(numero);
		conversation.end();
		result.include("dadosComprador",info);
		Compra compra = new Compra(info,carrinho);
		finalizador.fire(compra);
		//mandar email para o cliente
		//mandar email para o site
		//comunicar com os meios de pagamento
		//ClientBuilder.newBuilder().newClient().target("http://www.uol.com.br").request().async().get();		
//		result.forwardTo("/WEB-INF/jsp/pagamento/finalizado.jsp");
	}
	
}
