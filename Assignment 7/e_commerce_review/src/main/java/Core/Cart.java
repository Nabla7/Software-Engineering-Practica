package Core;

import java.util.HashMap;

public class Cart {
	
	private HashMap<Item, Integer> m_contents;
	
	/**
	 * Create an empty cart (for a new session)
	 */
	public Cart() {
		m_contents = new HashMap<Item, Integer>();
	}
	
	
	/**
	 * Add an item with quantity to the cart
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addItem(Item item, int quantity) {
		if (m_contents.containsKey(item)) {
			m_contents.put(item, m_contents.get(item) + quantity);
		} else {
			m_contents.put(item, quantity);
		}
	}
	
	
	/**
	 * Remove a quantity of an item from the Cart
	 * 
	 * @param item
	 * @param quantity
	 */
	public void removeItem(Item item, int quantity) {
		if (m_contents.containsKey(item)) {
			if (m_contents.get(item) >= quantity) {
				m_contents.put(item, m_contents.get(item) - quantity);
			}
		}
	}
	
	
	public HashMap<Item, Integer> contents() {
		return m_contents;
	}
	
	public double getTotalCost() {
		double cost = 0;
		for (Item i : m_contents.keySet()) {
			cost += i.price() * m_contents.get(i);
		}
		return cost;
	}
	
}
