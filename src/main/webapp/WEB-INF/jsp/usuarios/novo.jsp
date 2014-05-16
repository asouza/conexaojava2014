<form id="usuariosForm" action="<c:url value="/usuarios"/>" 
  method="POST">
  <fieldset>
    <legend>Criar novo usuário</legend>
        
    <label for="nome">Nome:</label>
      <input id="nome"  
        type="text" name="usuario.nome" value="${usuario.nome }"/>

    <label for="login">Login:</label>
      <input id="login"   
        type="text" name="usuario.login" value="${usuario.login }"/>

    <label for="senha">Senha:</label>
      <input id="senha"  type="password" 
      name="usuario.senha"/>

    <label for="confirmacao">Confirme a senha:</label>
      <input id="confirmacao" equalTo="#senha" type="password"/>
      
    <label for="opcaoDePerfil">Tipo de perfil</label>
    <select name="opcaoDePerfil">
    	<option value="ADMINISTRADOR">Admin</option>
    	<option value="VISITANTE">Visitante</option>
    </select>  

    <button type="submit">Enviar</button>
  </fieldset>
</form>

<script type="text/javascript">
  //$('#usuariosForm').validate();
</script>