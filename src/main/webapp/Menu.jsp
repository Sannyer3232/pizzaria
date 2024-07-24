<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Pizza"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
/* Estilos para a tabela */
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 1rem;
}

th, td {
	padding: 0.5rem;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

/* Estilos para os links de adicionar */
a {
	text-decoration: none;
	color: #007bff;
	font-weight: bold;
}

/* Estilos para os links de adicionar ao carrinho */
a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>Opções de Pizzas</h1>
	<a href="confirmarCarrinho">Ver Carrinho</a>
	<a href ="index.html"> Voltar</a>
	<%
		ArrayList<Pizza> pizzas = (ArrayList<Pizza>) request.getAttribute("pizzas");
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		if (pizzas != null && !pizzas.isEmpty()) {
	%>
	<table>
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Adicionar ao Carrinho</th>
		</tr>
		<%
		for (Pizza pizza : pizzas) {
		%>
		<tr>
			<td><%=pizza.getPizcodigo()%></td>
			<td><%=pizza.getPizanome()%></td>
			<td><%=pizza.getPizadescricao()%></td>
			<td><%=nf.format(pizza.getPizpreco())%></td>
			<td><a href="listarPizza?pizCodigo=<%=pizza.getPizcodigo()%>">Adicionar</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>Menu está vazio.</p>
	<%
	}
	%>
</body>
</html>
