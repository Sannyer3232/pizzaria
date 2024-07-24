package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns ={"/PedidoServlet", "/listarPedidos","/concluirPedido"})
public class PedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();

    public PedidoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/listarPedidos")) {
            try {
                listarPedidos(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(action.equals("/concluirPedido")) {
        	try {
        		atualizarStatusPedido(request,response);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected Carrinho adicionarAoCarrinho(int pizCodigo, int quantidade, Carrinho carrinho) {
        Pizza pizza = dao.listarPizza(pizCodigo);
        if (pizza != null) {
            Item item = new Item(pizza, quantidade);
            carrinho.adicionarItem(item);
        } else {
            System.out.println("Pizza com código " + pizCodigo + " não encontrada.");
        }
        return carrinho;
    }

    protected void listarPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pedido> pedidos = dao.listarPedidos();
        ArrayList<Carrinho> carrinhos = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            Carrinho carrinho = new Carrinho();
            String itemLista = pedido.getPddItens();
            if (itemLista.endsWith(";")) {
                itemLista = itemLista.substring(0, itemLista.length() - 1);
            }
            String[] pares = itemLista.split(";");
            for (String par : pares) {
                String[] partes = par.split("-");
                int codigo = Integer.parseInt(partes[0]);
                int quantidade = Integer.parseInt(partes[1]);
                adicionarAoCarrinho(codigo, quantidade, carrinho);
            }
            carrinhos.add(carrinho);
        }

        request.setAttribute("pedidos", pedidos);
        request.setAttribute("carrinhos", carrinhos);
        RequestDispatcher rd = request.getRequestDispatcher("listaPedidos.jsp");
        rd.forward(request, response);
    }
    
    protected void atualizarStatusPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = 0;
        codigo = Integer.parseInt(request.getParameter("pizCodigo"));
        String status = "Pedido Concluído";
        
        if(codigo != 0 && status != null ) {
        	try {
				dao.atualizaStatusPedido(codigo, status);
				response.sendRedirect(request.getContextPath() + "/listarPedidos");
			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}
        }
    }
}
