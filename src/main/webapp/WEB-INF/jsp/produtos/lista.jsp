<table>
  <thead>
    <tr>
      <th>Nome</th>
      <th>Descrição</th>
      <th>Preço</th>
      <th>Comprar</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${produtoList}" var="produto" varStatus="status">
      <tr>
        <td>${produto.nome }</td>
        <td>${produto.descricao }</td>
        <td>${produto.preco }</td>                
        <td>
		  <form action="<c:url value="/carrinho/${status.index}"/>"
		    method="POST">
		    <button class="link">
		      Remover
		    </button>
		  </form>        
        </td>
		<td>
          <!-- Adicionando o produto no carrinho de compras -->
          <form action="<c:url value="/carrinho"/>" method="post">
            <input type="hidden" name="item.produto.id" 
                      value="${produto.id }"/>
            <input class="qtde" name="item.quantidade" value="1"/>
            <button type="submit">Comprar</button>
          </form>
        </td>        
      </tr>          
    </c:forEach>
  </tbody>
</table>