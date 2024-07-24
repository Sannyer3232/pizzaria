package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/pizzaria?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "07114915Sa@";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirPizza(Pizza pizza) {
		String sp_cadastraPizza = "call sp_cadastraPizza(?,?,?,?);";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sp_cadastraPizza);

			pst.setString(1, pizza.getPizanome());
			pst.setString(2, pizza.getPizadescricao());
			pst.setFloat(3, pizza.getPizpreco());
			pst.setString(4, pizza.getPizfotocaminho());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Pizza> listarPizzas() {
	    ArrayList<Pizza> pizzas = new ArrayList<>();
	    String sp_listarPizzas = "select * from vw_pizzas;"; // Correção da chamada da procedure

	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(sp_listarPizzas);
	        ResultSet result = pst.executeQuery();

	        while (result.next()) {
	            int pizCodigo = result.getInt(1);
	            String pizNome = result.getString(2);
	            String pizDescricao = result.getString(3);
	            float pizPreco = result.getFloat(4);
	            String pizFotoNome = result.getString(5);

	         

	            pizzas.add(new Pizza(pizCodigo, pizNome, pizDescricao, pizPreco, pizFotoNome));
	        }
	        con.close();
	        System.out.println("Pizzas listadas com sucesso.");
	    } catch (Exception e) {
	        System.out.println("Erro ao listar pizzas: " + e);
	    }

	    return pizzas;
	}

	public Pizza listarPizza(int codigo) {
	    Pizza pizza = null;
	    String sp_listarPizza = "CALL sp_lista_pizza(?)"; // Correção da chamada da procedure

	    try (Connection con = conectar(); 
	         PreparedStatement pst = con.prepareStatement(sp_listarPizza)) {
	        
	        pst.setInt(1, codigo);
	        ResultSet result = pst.executeQuery();

	        while (result.next()) {
	            int pizCodigo = result.getInt(1);
	            String pizNome = result.getString(2);
	            String pizDescricao = result.getString(3);
	            float pizPreco = result.getFloat(4);
	            String pizFotoNome = result.getString(5);

	            System.out.println("Pizza encontrada: " + pizNome);

	            pizza = new Pizza(pizCodigo, pizNome, pizDescricao, pizPreco, pizFotoNome);
	        }
	        
	        System.out.println("Pizzas listadas com sucesso.");
	        return pizza;

	    } catch (SQLException e) {
	        System.out.println("Erro ao listar pizzas: " + e);
	    }

	    return null;
	}
	
	public void inserirPedido(Pedido pedido) {
		
		String sp_inserir = "call inserir_pedido (?,?,?,?,?,?);";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sp_inserir);

			pst.setString(1, pedido.getPddClienteNome());
			pst.setString(2, pedido.getPddClienteEndereco());
			pst.setString(3, pedido.getPddClienteTelefone());
			pst.setString(4, pedido.getPddItens());
			pst.setFloat(5, pedido.getPddTotal());
			pst.setString(6, pedido.getStatus());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public ArrayList<Pedido> listarPedidos() {
		Connection con = conectar();
		ArrayList<Pedido> pedidos = new ArrayList<>();
		
		String viewPedidos = "select * from vw_pedidos;";
		
		try {
			PreparedStatement pst = con.prepareStatement(viewPedidos);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int codigo = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String telefone = rs.getString(4);
				String itens = rs.getString(5);
				float total = Float.parseFloat(rs.getString(6));
				String status = rs.getString(7);
				
				pedidos.add(new Pedido(codigo,nome, endereco, telefone, itens, total, status ));
			}
			
			con.close();
			return pedidos;
		} catch (Exception e) {
			System.out.println("Erro: " + e);
			return null;
		}
	}
	
	public void atualizaStatusPedido(int codigo, String status) {
		String sp_atualizaStatus = "call sp_atualiza_status_pizza(?,?);";
		Connection con = conectar();
		 try {
			PreparedStatement pst = con.prepareStatement(sp_atualizaStatus);
			pst.setInt(1, codigo);
			pst.setString(2, status);
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}


}
