package br.com.caelum.vraptor.goodbuy.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.goodbuy.daos.UsuarioDAO;
import br.com.caelum.vraptor.goodbuy.models.Usuario;

@Controller
public class UsuariosController {
	
	@Inject
	private UsuarioDAO usuarios;

	@Get
	public void novo(){
		
	}
	
	@Post("/usuarios")
	@Transactional
	public void cria(Usuario usuario){
		usuarios.salva(usuario);
	}
}
