<form action="<c:url value="/compra/endereco?cid=${pagamentoController.conversationId}"/>" method="post">
  <fieldset>
    <legend>Endere�o de entrega</legend>
    
    <label for="endereco">Endere�o:</label>
    <input id="endereco" type="text" name="endereco"/>

    <button type="submit">Enviar</button>
  </fieldset>
</form>
