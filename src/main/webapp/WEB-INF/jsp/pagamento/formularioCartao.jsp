<form action="<c:url value="/compra/cartao?cid=${pagamentoController.conversationId}"/>" method="post">

  <fieldset>
    <legend>Dados do cart�o</legend>
    
    <label for="cartao">Cart�o:</label>
    <input id="cartao" type="text" name="numero"/>

    <button type="submit">Enviar</button>
  </fieldset>
</form>
