package Core;

import java.util.ArrayList;

public class Category {
	
	private ArrayList<String> m_categories;
	
	public Category() {
		m_categories = new ArrayList<String>();
		String[] basic_categories = {"Phone", "Tablet", "Computer", "Image", "Sound", "Home & Living", "Kitchen", "Travel", "Fashion", "Sport"};
		for (String cat : basic_categories) {
			m_categories.add(cat);
		}
	}
	
	public ArrayList<String> getCategories() {
		return m_categories;
	}
	
	public void addCategory(String category) {
		if (!m_categories.contains(category))
			m_categories.add(category);
	}
}
