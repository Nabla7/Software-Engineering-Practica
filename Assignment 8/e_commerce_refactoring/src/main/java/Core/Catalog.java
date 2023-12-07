package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Catalog {
	private HashMap<Integer, Item> m_all_items;
	
	/**
	 * Create new, empty Catalog
	 */
	public Catalog() {
		m_all_items = new HashMap<Integer, Item>();
	}
	
	
	/**
	 * Load existing catalog from file
	 * 
	 * @param filename
	 */
	public Catalog(String filename) {
		// Not implemented
		this();
	}
	
	
	/**
	 * Store the current catalog to file
	 * 
	 * @param filename
	 */
	public void store(String filename) {
		// Not implemented
	}
	
	
	/**
	 * Voeg item toe aan de catalogus
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		m_all_items.put(item.ID(), item);
	}
	
	public int getNumberOfItems() {
		return m_all_items.size();
	}
	
	public Item getItemByID(int id) {
		return m_all_items.get(id);
	}
	
	public Set<Integer> getAllIDs() {
		return m_all_items.keySet();
	}
	
	public ArrayList<Item> filterCategories(HashSet<String> categories) {
		ArrayList<Item> filtered_items = new ArrayList<Item>();
		
		for (Integer iid : m_all_items.keySet()) {
			HashSet<String> check = new HashSet<String>(categories);
			check.retainAll(m_all_items.get(iid).category());
			if (check.size() > 0)
				filtered_items.add(m_all_items.get(iid));
		}
		
		return filtered_items;
	}
}
