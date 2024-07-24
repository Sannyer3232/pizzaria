package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Dao;
import model.Pizza;

/**
 * Servlet implementation class Admin
 */
@WebServlet(urlPatterns = {"/Admin","/insertPizza"})
@MultipartConfig(maxFileSize = 16177215) // 16 MB
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Dao dao = new Dao();
	Pizza pizza = new Pizza();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if(action.equals("/insertPizza")) {
			try {
				novaPizza(request,response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	protected void novaPizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        pizza.setPizanome(request.getParameter("piznome"));
        pizza.setPizadescricao(request.getParameter("pizdescricao"));
        pizza.setPizpreco(Float.parseFloat(request.getParameter("pizpreco")));

        String path = getServletContext().getRealPath("/imagens");
        File fileSaveDir = new File(path);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        String msg = "Arquivo enviado com sucesso";

        try {
            for (Part part : request.getParts()) {
                if (part.getName().equals("pizfoto")) {
                    String fileName = part.getSubmittedFileName();
                    String caminho = path + File.separator + fileName;
                    part.write(caminho);
                    pizza.setPizfotocaminho(caminho);
                    System.out.println(msg);
                }
            }
        } catch (Exception e) {
            msg = "Erro ao salvar a imagem";
            e.printStackTrace();
        }

        System.out.println("Nome: " + pizza.getPizanome());
        System.out.println("Descricao: " + pizza.getPizadescricao());
        System.out.println("Preço: " + pizza.getPizpreco());
        System.out.println("Foto: " + pizza.getPizfotocaminho());

        dao.inserirPizza(pizza);
        response.sendRedirect("cadastroPizza.jsp");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
