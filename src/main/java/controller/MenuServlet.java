package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao;
import model.Pizza;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet(urlPatterns = {"/MenuServlet", "/Menu", "/listarPizza"})
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Dao dao = new Dao();

    public MenuServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/Menu")) {
            try {
                listarPizzas(request, response);
            } catch (Exception e) {
                System.out.println("Erro no doGet: " + e);
            }
        }else if(action.equals("/listarPizza")) {
        	try {
        		listarPizza(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void listarPizzas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pizza> pizzas = dao.listarPizzas();
        System.out.println("Total de pizzas listadas: " + pizzas.size());

        request.setAttribute("pizzas", pizzas);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
    
    protected void listarPizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int codigo = Integer.parseInt(request.getParameter("pizCodigo"));
    	Pizza pizza = dao.listarPizza(codigo);


        request.setAttribute("pizza", pizza);
        RequestDispatcher rd = request.getRequestDispatcher("compra.jsp");
        rd.forward(request, response);
      
    }
}
