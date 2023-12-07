package Core;

import java.util.HashSet;

public class Item {
	private int m_iid;
	
	private String m_name;
	private String m_desc;
	private float m_price;
	private HashSet<String> m_category;
	
	/**
	 * Create new Item
	 * 
	 * @param name
	 * @param desc
	 * @param price
	 */
	public Item(String name, String desc, float price) {
		
	}
	
	public int ID() {
		return m_iid;
	}
	
	public String name() {
		return m_name;
	}
	
	public String desc() {
		return m_desc;
	}
	
	public float price() {
		return m_price;
	}
	
	public HashSet<String> category() {
		return m_category;
	}
}
