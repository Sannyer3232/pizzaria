<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/estilo.css">
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

    <div class="container">
        <h5>Cadastro de Pizzas</h5>  <a href = "listarPedidos" class="add-btn">Listar Pedidos</a>
            <form class="pizza-form" action ="insertPizza" method ="post" enctype="multipart/form-data">
                <div class="form-group-cadastro">
                    <label for="name">Nome da Pizza:</label>
                    <input type="text" id="name" name="piznome" required>
                </div>
                <div class="form-group-cadastro">
                    <label for="description">Descrição:</label>
                    <textarea id="description" name="pizdescricao" required></textarea>
                </div>
                <div class="form-group-cadastro">
                    <label for="price">Preço:</label>
                    <input type="number" id="price" name="pizpreco" required>
                </div>
                <div class="form-group-cadastro">
                    <label for="image">Foto:</label>
                    <input type="file" id="image" name="pizfoto" required>
                </div>
                <button type="submit" class="submit-btn-cadastro">Cadastrar</button>
            </form>
    </div>

    <script src="script.js"></script>
</body>
</html>


