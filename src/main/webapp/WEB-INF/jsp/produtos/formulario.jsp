<form action="<c:url value="/produtos"/>" method="post" id="produtosForm">
  <fieldset>
    <legend>Adicionar Produto</legend>
    
    <label for="nome">Nome:</label>
    <input id="nome" type="text" name="produto.nome" value="${produto.nome}" class="required" minlength="3"/>

    <label for="descricao">Descrição:</label>
    <textarea  class="required" maxlength="40" id="descricao" name="produto.descricao">${produto.descricao}</textarea>

    <label for="preco">Preço:</label>
    <input id="preco" type="text" name="produto.preco" min="0" value="${produto.preco}"/>

    <button type="submit">Enviar</button>
  </fieldset>
</form>
<script type="text/javascript">
//   $('#produtosForm').validate();
</script>