package br.com.caelum.vraptor.goodbuy.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.vraptor.goodbuy.models.Usuario;

public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario carrega(String login) {
		return manager.createQuery("select u from Usuario u where u.login=:login", Usuario.class)
				.setParameter("login", login).getSingleResult();
	}

}
