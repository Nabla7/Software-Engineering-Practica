package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Orders {
	private List<Order> m_orders;
	private HashMap<Integer, Order> m_id_order;
	
	/**
	 * Create empty order history
	 */
	public Orders() {
		m_orders = new ArrayList<Order>();
		m_id_order = new HashMap<Integer, Order>();
	}
	
	
	public void addOrder(Order order) {
		m_orders.add(order);
		m_id_order.put(order.ID(), order);
	}
	
	public List<Order> getAllOrders() {
		return m_orders;
	}
	
	public Order getOrder(int oid) {
		return m_id_order.get(oid);
	}
	
	public Order_Status getOrderStatus(int oid) {
		return m_id_order.get(oid).getStatus();
	}
	
	public boolean requestOrderCancel(int oid) {
		for (Order o : m_orders) {
			if (o.ID() == oid) {
				return o.requestCancel();
			}
		}
		return false;
	}
	
	
}
