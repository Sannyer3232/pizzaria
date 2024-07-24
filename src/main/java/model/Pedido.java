package model;

import java.util.ArrayList;

public class Pedido {
	
	private int pddcodigo;
	private String pddClienteNome;
	private String pddClienteEndereco;
	private String pddClienteTelefone;
	private String pddItens;
	private float pddTotal;
	private String status;
	
	
	
	
	
	
	public Pedido(int pddcodigo, String pddClienteNome, String pddClienteEndereco, String pddClienteTelefone,
			String pddItens, float pddTotal) {
		this.pddcodigo = pddcodigo;
		this.pddClienteNome = pddClienteNome;
		this.pddClienteEndereco = pddClienteEndereco;
		this.pddClienteTelefone = pddClienteTelefone;
		this.pddItens = pddItens;
		this.pddTotal = pddTotal;
		
	}
	
	
	public Pedido(int pddcodigo, String pddClienteNome, String pddClienteEndereco, String pddClienteTelefone,
			String pddItens, float pddTotal, String status) {
		this.pddcodigo = pddcodigo;
		this.pddClienteNome = pddClienteNome;
		this.pddClienteEndereco = pddClienteEndereco;
		this.pddClienteTelefone = pddClienteTelefone;
		this.pddItens = pddItens;
		this.pddTotal = pddTotal;
		this.status = status;
	}


	public Pedido(String pddClienteNome, String pddClienteEndereco, String pddClienteTelefone, String pddItens,
			float pddTotal, String status) {
		this.pddClienteNome = pddClienteNome;
		this.pddClienteEndereco = pddClienteEndereco;
		this.pddClienteTelefone = pddClienteTelefone;
		this.pddItens = pddItens;
		this.pddTotal = pddTotal;
		this.status = status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getPddcodigo() {
		return pddcodigo;
	}
	public void setPddcodigo(int pddcodigo) {
		this.pddcodigo = pddcodigo;
	}
	public String getPddClienteNome() {
		return pddClienteNome;
	}
	public void setPddClienteNome(String pddClienteNome) {
		this.pddClienteNome = pddClienteNome;
	}
	public String getPddClienteEndereco() {
		return pddClienteEndereco;
	}
	public void setPddClienteEndereco(String pddClienteEndereco) {
		this.pddClienteEndereco = pddClienteEndereco;
	}
	public String getPddClienteTelefone() {
		return pddClienteTelefone;
	}
	public void setPddClienteTelefone(String pddClienteTelefone) {
		this.pddClienteTelefone = pddClienteTelefone;
	}
	public String getPddItens() {
		return pddItens;
	}
	public void setPddItens(String pddItens) {
		this.pddItens = pddItens;
	}
	public float getPddTotal() {
		return pddTotal;
	}
	public void setPddTotal(float pddTotal) {
		this.pddTotal = pddTotal;
	}
	
	
	
	
	
}
