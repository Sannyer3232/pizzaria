package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrinho;
import model.Dao;
import model.Item;
import model.Pedido;
import model.Pizza;

@WebServlet(urlPatterns = { "/Carrinho", "/adicionarAoCarrinho", "/confirmarcompra", 
		"/confirmarCarrinho","/removerItem"})
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Carrinho carrinho;
	private Dao dao;

	public CarrinhoServlet() {
		super();
		carrinho = new Carrinho();
		dao = new Dao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if (action.equals("/adicionarAoCarrinho")) {
			try {
				adicionarAoCarrinho(request, response);
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}

		} else if (action.equals("/confirmarCarrinho")) {
			try {
				verCarrinho(request, response);
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
		} else if (action.equals("/confirmarcompra")) {
			try {
				confirmarPedido(request, response);
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
		}else if (action.equals("/removerItem")) {
			try {
				removerItem(request, response);
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void adicionarAoCarrinho(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pizCodigo = Integer.parseInt(request.getParameter("pizCodigo"));
		int quantidade = Integer.parseInt(request.getParameter("pizQuantidade"));

		System.out.println("Código da pizza recebido: " + pizCodigo);
		System.out.println("Quantidade recebida: " + quantidade);

		Pizza pizza = dao.listarPizza(pizCodigo);

		if (pizza != null) {
			Item item = new Item(pizza, quantidade);
			carrinho.adicionarItem(item);
			System.out.println("Item adicionado ao carrinho: " + pizza.getPizanome() + " - Quantidade: " + quantidade);
		} else {
			System.out.println("Pizza com código " + pizCodigo + " não encontrada.");
		}

		// Imprimir a quantidade total de pizzas no carrinho após adicionar o item
		ArrayList<Item> itensNoCarrinho = carrinho.getItens();
		int quantidadeTotal = 0;
		for (Item it : itensNoCarrinho) {
			quantidadeTotal += it.getQuantidade();
		}
		System.out.println("Quantidade total de pizzas no carrinho: " + quantidadeTotal);

		// Redirecionar de volta para a página de menu ou para o carrinho, conforme
		// necessário
		response.sendRedirect(request.getContextPath() + "/Menu");
	}

	protected void verCarrinho(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("cart", carrinho);
		RequestDispatcher rd = request.getRequestDispatcher("Carrinho.jsp");
		rd.forward(request, response);

	}

	protected void confirmarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String clienteNome = request.getParameter("pddclientenome");
		String clienteEndereco = request.getParameter("pddclienteendereco");
		String clienteTelefone = request.getParameter("pddclientetelefone");
		String status = "Em preparo";

		// Use StringBuilder para construir a string de itens
		StringBuilder itens = new StringBuilder();

		ArrayList<Item> Itens_para_pedido = carrinho.getItens();

		for (Item item : Itens_para_pedido) {
			// Concatena o código da pizza e a quantidade, separando-os por ";"
			itens.append(item.getPizza().getPizcodigo()).append("-").append(item.getQuantidade()).append(";");
		}

		// Converte o StringBuilder para uma string
		String itensConcatenados = itens.toString();

		Pedido pedido = new Pedido(clienteNome, clienteEndereco, clienteTelefone, itensConcatenados,
				carrinho.getprecoTotal(), status);

		dao.inserirPedido(pedido);
		carrinho.getItens().clear();
		response.sendRedirect(request.getContextPath() + "/Menu");
	}

	protected void removerItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = 0;

		codigo= Integer.parseInt(request.getParameter("pizCodigo"));
		
		if(codigo != 0 && carrinho != null) {
			carrinho.removerItem(codigo);
		}
		
		response.sendRedirect(request.getContextPath() + "/confirmarCarrinho");
	}
}
