package br.com.caelum.vraptor.goodbuy.notificacoes;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/controlador-de-slide/{userType}")
public class ControladorDeSlides {
	
	@Inject
	private Channel channel;

	@OnOpen
	public void newUser(Session session,@PathParam("userType") String userType){
		channel.add(session);
	}
	
	@OnMessage
	public void changeSlide(String message,@PathParam("userType") String userType){
		if(userType.equals("grandebahia")){
			channel.send(message);
		}
	}
}
