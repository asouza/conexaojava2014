<form action="<c:url value="/compra/endereco?cid=${pagamentoController.conversationId}"/>" method="post">
  <fieldset>
    <legend>Endereço de entrega</legend>
    
    <label for="endereco">Endereço:</label>
    <input id="endereco" type="text" name="endereco"/>

    <button type="submit">Enviar</button>
  </fieldset>
</form>
