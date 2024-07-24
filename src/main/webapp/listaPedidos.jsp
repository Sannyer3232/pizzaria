<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Carrinho"%>
<%@ page import="model.Pizza"%>
<%@ page import="model.Item"%>
<%@ page import="model.Pedido"%>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Pizzaria Delicias - Pedidos</title>
</head>
<body class = "corpo">
	<header class="content-itens">
		<div class="logo">
			<img src="./imagens/logo.png" alt="">
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


	<div class="pedidos-lista">

		<%
		ArrayList<Pedido> pedidos = (ArrayList<Pedido>) request.getAttribute("pedidos");
		ArrayList<Carrinho> carrinhos = (ArrayList<Carrinho>) request.getAttribute("carrinhos");
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		if (pedidos != null && !pedidos.isEmpty() && carrinhos != null && !carrinhos.isEmpty()) {
			for (int i = 0; i < pedidos.size(); i++) {
				Pedido pedido = pedidos.get(i);
				Carrinho carrinho = carrinhos.get(i);
				ArrayList<Item> itens = carrinho.getItens();
		%>
		<table class="detalhe">

			<tr>
				
				<th>Nº Pedido</th>
				<th>Nome Cliente</th>
				<th>Endereço</th>
				<th>Telefone</th>
				<th>Total do Pedido</th>
				
				<th>Status</th>
				<th>Ação</th>
				
			</tr>
			<tr>
				<td><%=pedido.getPddcodigo()%></td>
				<td><%=pedido.getPddClienteNome()%></td>
				<td><%=pedido.getPddClienteEndereco()%></td>
				<td><%=pedido.getPddClienteTelefone()%></td>
				<td><%=nf.format(pedido.getPddTotal())%></td>
				<td><%=pedido.getStatus()%></td>
				<td><button class="botao"
						onclick="location.href='concluirPedido?pizCodigo=<%=pedido.getPddcodigo()%>'">
						Concluir Pedido</button></td>
			</tr>
		</table>
		<table class="itens">
			<tr>
				<th>Pizza</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Quantidade</th>
				<th>Valor Parcial</th>
			</tr>
			<%
			for (Item item : itens) {
			%>
			<tr>
				<td><%=item.getPizza().getPizanome()%></td>
				<td><%=item.getPizza().getPizadescricao()%></td>
				<td><%=nf.format(item.getPizza().getPizpreco())%></td>
				<td><%=item.getQuantidade()%></td>
				<td><%=nf.format(item.getPrecoTotal())%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		} else {
		%>
		<p>
			Lista de Pedidos está vazia. <a href="Menu">Voltar ao Menu</a>
		</p>
		<%
		}
		%>

	</div>

	<script src="javaScript/script.js"></script>
</body>
</html>
