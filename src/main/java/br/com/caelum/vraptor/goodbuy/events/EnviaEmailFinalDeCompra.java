package br.com.caelum.vraptor.goodbuy.events;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.caelum.vraptor.goodbuy.models.Compra;

@RequestScoped
public class EnviaEmailFinalDeCompra {
	@Resource(mappedName = "java:/mail/gmail")
	private Session session;

	public void envia(@Observes Compra compra) {

		try {

			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(compra.getInfo().getUsuario().getEmail()));
			message.setSubject("Sua compra foi registrada");
			message.setText("Amigão, fico feliz que vc tenha comprado conosco :)");

			Transport.send(message);

		} catch (MessagingException e) {
			Logger.getLogger(EnviaEmailFinalDeCompra.class.getName()).log(Level.WARNING, "Cannot send mail", e);
		}
	}
}
