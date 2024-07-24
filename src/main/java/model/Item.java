package model;

public class Item {
	
	private Pizza pizza;
	private int quantidade;
	
	
	public Item(Pizza pizza, int quantidade) {
		this.pizza = pizza;
		this.quantidade = quantidade;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getPrecoTotal() {
		return pizza.getPizpreco()*quantidade;
	}

	
}
