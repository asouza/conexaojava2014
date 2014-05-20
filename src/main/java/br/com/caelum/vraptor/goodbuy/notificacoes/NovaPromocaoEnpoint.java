package br.com.caelum.vraptor.goodbuy.notificacoes;

import java.io.IOException;

import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/novas-promocoes")
public class NovaPromocaoEnpoint {

	@Inject
	private Channel channel;
	
	@OnOpen
	public void onMessage(Session session) throws IOException {
		System.out.println("adicionando um usuario");
		channel.add(session);
	}
	
	@OnClose
	public void onClose(Session session,CloseReason closeReason){
		channel.remove(session);
		System.out.println("Conexão perdida => "+closeReason.getReasonPhrase());
	}
	
}
