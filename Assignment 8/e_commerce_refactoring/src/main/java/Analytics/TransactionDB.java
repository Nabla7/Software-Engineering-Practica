package Analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import Core.Catalog;
import Core.Item;
import Core.Order;
import Core.Orders;

public class TransactionDB {
	private HashMap<Integer, ArrayList<Integer>> m_tidlist;
	
	public TransactionDB(Catalog catalog, Orders orders) throws Exception {
		m_tidlist = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int item_id : catalog.getAllIDs()) {
			m_tidlist.put(catalog.getItemByID(item_id).ID(), new ArrayList<Integer>());
		}
		
		List<Order> order_list = orders.getAllOrders();
		for (Order order : order_list) {
			for (Item item : order.getItems().keySet()) {
				int cid = order.getClient().ID();
				if( !m_tidlist.get(item).contains(cid) )
					m_tidlist.get(item).add(cid);
			}
		}
	}
	
	public Set<Integer> getIDs() {
		return m_tidlist.keySet();
	}
	
	public ArrayList<Integer> getClients(int item) {
		ArrayList<Integer> tmp = m_tidlist.get(item);
		Collections.sort(tmp);
		return tmp;
	}
}
