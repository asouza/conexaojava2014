package br.com.caelum.vraptor.goodbuy.models;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class UsuarioWeb implements Serializable {

	private Usuario usuario;

	public void login(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return usuario.getNome();
	}

	public void logout() {
		this.usuario = null;
	}

	public boolean isLogado() {
		return this.usuario != null;
	}

}
