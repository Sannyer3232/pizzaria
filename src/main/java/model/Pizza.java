package model;

public class Pizza {
	private int pizcodigo;
	private String pizanome;
	private String pizadescricao;
	private float pizpreco;
	private String pizfotocaminho;
	
	
	public Pizza() {}
	
	
	public Pizza(String pizanome, String pizadescricao, float pizpreco, String pizfotocaminho) {
		this.pizanome = pizanome;
		this.pizadescricao = pizadescricao;
		this.pizpreco = pizpreco;
		this.pizfotocaminho = pizfotocaminho;
	}
	
	public Pizza(int pizcodigo, String pizanome, String pizadescricao, float pizpreco, String pizfotocaminho) {
		this.pizcodigo = pizcodigo;
		this.pizanome = pizanome;
		this.pizadescricao = pizadescricao;
		this.pizpreco = pizpreco;
		this.pizfotocaminho = pizfotocaminho;
	}

	




	public String getPizfotocaminho() {
		return pizfotocaminho;
	}

	public void setPizfotocaminho(String pizfotocaminho) {
		this.pizfotocaminho = pizfotocaminho;
	}

	public int getPizcodigo() {
		return pizcodigo;
	}
	public void setPizcodigo(int pizcodigo) {
		this.pizcodigo = pizcodigo;
	}
	public String getPizanome() {
		return pizanome;
	}
	public void setPizanome(String pizanome) {
		this.pizanome = pizanome;
	}
	public String getPizadescricao() {
		return pizadescricao;
	}
	public void setPizadescricao(String pizadescricao) {
		this.pizadescricao = pizadescricao;
	}
	public float getPizpreco() {
		return pizpreco;
	}
	public void setPizpreco(float pizpreco) {
		this.pizpreco = pizpreco;
	}
	
	
	

}
