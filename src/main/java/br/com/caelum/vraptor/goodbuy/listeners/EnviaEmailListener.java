package br.com.caelum.vraptor.goodbuy.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.handlers.message_rfc822;

import br.com.caelum.vraptor.goodbuy.events.EnviaEmailFinalDeCompra;
import br.com.caelum.vraptor.goodbuy.models.Compra;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/emails"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class EnviaEmailListener implements MessageListener {

	@Resource(mappedName = "java:/mail/gmail")
	private Session session;

	@Override
	public void onMessage(Message jmsMessage) {

		System.out.println("Enviando email!!!");
		ObjectMessage objectMessage = (ObjectMessage) jmsMessage;
		try {
			Compra compra = (Compra) objectMessage.getObject();
			javax.mail.Message message = new MimeMessage(session);
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(compra.getInfo().getUsuario().getEmail()));
			message.setSubject("Sua compra foi registrada");
			message.setText("Amigão, fico feliz que vc tenha comprado conosco :)");

			Transport.send(message);

		} catch (Exception e) {
			Logger.getLogger(EnviaEmailFinalDeCompra.class.getName()).log(Level.WARNING, "Cannot send mail", e);
		}
	}

}
