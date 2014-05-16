<form action="<c:url value="/compra/cartao?cid=${pagamentoController.conversationId}"/>" method="post">

  <fieldset>
    <legend>Dados do cartão</legend>
    
    <label for="cartao">Cartão:</label>
    <input id="cartao" type="text" name="numero"/>

    <button type="submit">Enviar</button>
  </fieldset>
</form>
