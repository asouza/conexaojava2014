package br.com.caelum.vraptor.goodbuy.notificacoes;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

@ApplicationScoped
public class Channel {

	private List<Session> users = new CopyOnWriteArrayList<>();

	public void send(String message) {
		try {
			for (Session user : users) {
				if (user.isOpen()) {
					System.out.println("enviando mensagem");
					user.getBasicRemote().sendText(message);
				}
			}
		} catch (IOException e) {
			System.err.println("Problema ao enviar a mensagem para o usuario. " + e);
		}
	}

	public void add(Session session) {
		users.add(session);
		System.out.println(users.size());
	}

	public void remove(Session session) {
		users.remove(session);
	}

}
