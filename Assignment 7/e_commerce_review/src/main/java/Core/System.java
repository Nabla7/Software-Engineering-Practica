package Core;

import java.util.HashMap;

import Core.Clients.Client;
import Core.Clients.Clients;

public class System {
	
	private Catalog m_catalog;
	private Orders m_orders;
	private Clients m_clients;
	
	private HashMap<Integer, Cart> m_carts;
	private HashMap<Integer, Client> m_logged_in_clients;
	
	public System() {
		m_catalog = new Catalog();
		m_orders = new Orders();
	
		m_carts = new HashMap<Integer, Cart>();
	}
	
	public void newCart(int userID) {
		m_carts.put(userID, new Cart());
	}
	
	public void removeCart(int userID) {
		m_carts.remove(userID);
	}
	
	public void addItemToCart(int userID, int itemID) {
		m_carts.get(userID).addItem(m_catalog.getItemByID(itemID), 1);
	}
	
	public void addItemToCart(int userID, int itemID, int amount) {
		m_carts.get(userID).addItem(m_catalog.getItemByID(itemID), amount);
	}
	
	public void removeItemFromCart(int userID, int itemID) {
		m_carts.get(userID).removeItem(m_catalog.getItemByID(itemID), 1);
	}
	
	public void removeItemFromCart(int userID, int itemID, int amount) {
		m_carts.get(userID).removeItem(m_catalog.getItemByID(itemID), amount);
	}
	
	public boolean login(int userID, String username, String password) {
		Client client = m_clients.getRegisteredClient(username, password);
		if (client == null)
			return false;
		m_logged_in_clients.put(userID, client);
		return true;
	}
	
	public void orderCart(int userID, Client client) {
		m_orders.addOrder(new Order(m_carts.get(userID), client));
	}
	
	public void orderCart(int userID) {
		m_orders.addOrder(new Order(m_carts.get(userID), m_logged_in_clients.get(userID)));
	}
}
