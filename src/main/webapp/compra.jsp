<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Pizza"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <script>
        function esconderCampoPesquisa() {
            this.style.display = 'none';
        }
    </script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <title>Detalhes</title>
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
        <h5>Detalhes do Pedido</h5>
        <% 
            Pizza pizza = (Pizza) request.getAttribute("pizza");
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));    
        %>
        <form action="adicionarAoCarrinho" method="post">
            <table class="cart">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%= pizza.getPizanome() %></td>
                        <td><%= pizza.getPizadescricao() %></td>
                        <td><%= nf.format(pizza.getPizpreco()) %></td>
                        <td><input type="number" min="1" name="pizQuantidade" class="quantity-input" required></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" value="<%= pizza.getPizcodigo() %>" name="pizCodigo">
            <button class="add-btn" type="submit">Adicionar</button>
        </form>
    </div>
    <script src="script.js"></script>
</body>
</html>
