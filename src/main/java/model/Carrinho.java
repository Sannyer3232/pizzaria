package model;

import java.util.ArrayList;

public class Carrinho {


	private ArrayList<Item> itens = new ArrayList<>();

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	public void adicionarItem(Pizza pizza, int quantidade) {

		itens.add(new Item(pizza, quantidade));
	}

	public void adicionarItem(Item item) {
		itens.add(item);
	}


	public void removerItem(int pizCodigo) {

		itens.removeIf(item -> item.getPizza().getPizcodigo() == pizCodigo);

	}

	public float getprecoTotal() {
		float precoTotal = 0;
		for (Item item : itens) {
			precoTotal += item.getPrecoTotal();
		}

		return precoTotal;
	}

}
