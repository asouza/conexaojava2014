package br.com.caelum.vraptor.goodbuy.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.goodbuy.daos.UsuarioDAO;
import br.com.caelum.vraptor.goodbuy.models.Usuario;
import br.com.caelum.vraptor.goodbuy.models.UsuarioWeb;

@Controller
public class UsuariosController {
	
	@Inject
	private UsuarioDAO usuarios;
	@Inject
	private Result result;
	@Inject
	private UsuarioWeb usuarioWeb;

	@Get
	public void novo(){
		
	}
	
	@Post("/usuarios")
	@Transactional
	public void cria(Usuario usuario){
		usuarios.salva(usuario);
	}
	
	public void loginForm(){	
		System.out.println("formulario de login");
	}
	
	public void login(Usuario usuario){
		usuarioWeb.login(usuarios.carrega(usuario.getLogin()));
		result.redirectTo(ProdutosController.class).lista();
	}	
}
