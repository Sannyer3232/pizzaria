<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<%@ page import="model.Pizza"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<title>Pizzaria Delicias</title>
</head>
<body>
	<header class="content">
		<div class="logo">
			<img src="./imagens/logo.png" alt="">
			<h3>Pizzaria Delicias</h3>
		</div>
		<nav>
			<ul class="list-menu">
				<li><a href="#home">Home</a></li>
				<li><a href="#sobrenos">Sobre</a></li>
				<li><a href="#menu">Menu</a></li>
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

	<section class="first-section" id="home">
		<div class="conteudo-principal">
			<h1>Bem vindos a Pizzaria Delicias!</h1>
			<h2>Deixe seu dia mais saboroso, com as pizzas mais recheadas da
				região</h2>
			<div class="btn">
				<button class="reservar">Reserve a sua</button>
				<button class="montar">Montar a sua pizza</button>
			</div>
		</div>
	</section>

	<section class="sobre" id="sobrenos">
		<div class="main">
			<div class="contentsobre">
				<h2>Sobre nós</h2>
				<p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.
					Dicta iure deserunt ad mollitia exercitationem blanditiis? Quaerat
					incidunt quod, itaque, veritatis ad laudantium ex vel corporis
					consequatur, earum repellat blanditiis magnam.</p>
			</div>

			<div class="img-cozinha">
				<img src="./imagens/sobrenos.png" alt="">
			</div>
		</div>
	</section>

	<section class="menu" id="menu">
	<%
		ArrayList<Pizza> pizzas = (ArrayList<Pizza>) request.getAttribute("pizzas");
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		if (pizzas != null && !pizzas.isEmpty()) {
	%>
		<h2>Menu</h2>
		<div class="itens-menu">
		<%
		for (Pizza pizza : pizzas) {
		%>
			<div class="item">
				<img src="imagens/<%=pizza.getPizfotocaminho() %>" alt="">
				<div class="info">
					<h3><%=pizza.getPizanome()%></h3>
					<h4><%=pizza.getPizadescricao()%></h4>
					<h4><%=nf.format(pizza.getPizpreco())%></h4>
					<button class="pedir" onclick = "location.href='listarPizza?pizCodigo=<%=pizza.getPizcodigo()%>'">Adicionar ao carrinho</button>
				</div>
			</div>
			<%} %>
		<%} %>
		</div>
	</section>




	<section class="contatos" id="contatos">
		<h3>Contatos</h3>
		<div class="contatos-secao">
			<div>
				<i class="bi bi-telephone"></i> <span>(92) 91234-5678</span>
			</div>
			<div>
				<i class="bi bi-envelope"></i> <span>contato@pizzariadelicias.com</span>
			</div>
			<div>
				<i class="bi bi-geo-alt-fill"></i> <span>Rua do Café, 123 -
					Centro</span>
			</div>
			<div>
				<i class="bi bi-instagram"></i> <span>@pizzariadelicias</span>
			</div>
		</div>
	</section>
	<footer>
		<h4>Todos os Direitos Reservados</h4>
	</footer>
	<script src="script.js"></script>
</body>
</html>