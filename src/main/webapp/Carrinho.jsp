<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Carrinho"%>
<%@ page import="model.Pizza"%>
<%@ page import="model.Item"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script>
        function confirmarRemocao(pizCodigo) {
            if (confirm("Tem certeza de que deseja remover este item do carrinho?")) {
                window.location.href = "removerItem?pizCodigo=" + pizCodigo;
            }
        }

        function confirmarPedido() {
            return confirm("Tem certeza de que deseja confirmar o pedido?");
        }
    </script>
    <title>Pizzaria Delicias</title>
</head>
<body>
    <header class="content">
        <div class="logo">
            <img src="imagens/logo.png" alt="">
            <h3>Pizzaria Delicias</h3>
        </div>
        <nav>
            <ul class="list-menu">
                <li><a href="#home">Home</a></li>
                <li><a href="#sobrenos">Sobre</a></li>
                <li><a href="Menu">Menu</a></li>
                <li><a href="#contatos">Contatos</a></li>
                <li><a href="cadastroPizza.jsp">Administração</a></li>
                <li><a href="confirmarCarrinho"><i class="bi bi-cart2"></i></a></li>
            </ul>
        </nav>

        <div class="menu-toggle">
            <div class="one"></div>
            <div class="two"></div>
            <div class="three"></div>
        </div>
    </header>
    <div class="container">
        
        <%
    Carrinho carrinho = (Carrinho) request.getAttribute("cart");
    ArrayList<Item> itens = carrinho.getItens();
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    if (itens != null && !itens.isEmpty()) {
    %>
        <table class="cart">
            <thead>
                <tr>
                    <th>Produto</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Valor Parcial</th>
                    <th>Total</th>
                    <th>Remover</th>
                </tr>
            </thead>
            <tbody>
                <% for(Item item : itens){%>
                <tr>
                    <td><img src="./imagens/<%=item.getPizza().getPizfotocaminho() %>" ></td>
                    <td>
                        <h2><%=item.getPizza().getPizanome() %></h2>
                        <p><%=item.getPizza().getPizadescricao() %></p>
                    </td>
                    <td><%=nf.format(item.getPizza().getPizpreco()) %></td>
                    <td><%=item.getQuantidade()%></td>
                    <td><%=nf.format(item.getPrecoTotal()) %></td>
                    <td><%=nf.format(carrinho.getprecoTotal()) %></td>
                    <td><a class="remove-btn" href="removerItem?pizCodigo=<%=item.getPizza().getPizcodigo()%>" onclick="confirmarRemocao();">Remover</a></td>
                </tr>
               
                <!-- Mais itens podem ser adicionados aqui -->
            </tbody>
            <%}%>
        </table>
        
        <h2>Detalhes do Cliente</h2>
        <form class="customer-form" action="confirmarcompra" method="post" onsubmit="return confirmarPedido();">
            <div class="form-group">
                <label for="name">Nome:</label>
                <input type="text" id="name" name="pddclientenome" required>
            </div>
            <div class="form-group">
                <label for="address">Endereço:</label>
                <input type="text" id="address" name="pddclienteendereco" required>
            </div>
            <div class="form-group">
                <label for="phone">Telefone:</label>
                <input type="tel" id="phone" name="pddclientetelefone" required>
            </div>
            <button type="submit" class="submit-btn">Enviar Pedido</button>
        </form>
        <%}else{ %>
           
    </div>
     <div class="conteudo-principal">
			<h1>Carrinho Vazio</h1>
			<div class="btn">
				<button class="reservar" onclick = "location.href='Menu'">Voltar</button>
			</div>
		</div>
    <%} %>
    <script src="javaScript/script.js"></script>
</body>
</html>