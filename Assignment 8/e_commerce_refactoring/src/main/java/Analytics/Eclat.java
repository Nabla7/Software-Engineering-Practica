package Analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Core.Catalog;


public class Eclat {

	private TransactionDB m_db;
	private Catalog m_catalog;
	
	private ArrayList<ArrayList<Set<Integer>>> m_found_itemsets;
	private HashMap<Set<Integer>, ArrayList<Integer>> m_itemsets;
	
	public Eclat(TransactionDB db, Catalog catalog) {
		m_db = db;
		m_catalog = catalog;
	}
	
	public ArrayList<ArrayList<Set<Integer>>> calculate(int min_sup) {
		// Add all single items with support above min_sup
		int itemset_size = 0;

		m_found_itemsets = new ArrayList<ArrayList<Set<Integer>>>();
		m_found_itemsets.add(new ArrayList<Set<Integer>>());
		
		m_itemsets = new HashMap<Set<Integer>, ArrayList<Integer>>();
		
		System.out.println("ECLAT: First iteration");
		for(int item : m_db.getIDs()) {
			if( m_db.getClients(item).size() >= min_sup ) {
				Set<Integer> tmp = new HashSet<Integer>();
				tmp.add(item);
				m_found_itemsets.get(itemset_size).add(tmp);
				m_itemsets.put(tmp, m_db.getClients(item));
			}
		}
		
		boolean found = true;
		while(found) {
			itemset_size++;
			m_found_itemsets.add(new ArrayList<Set<Integer>>());
			found = false;
			System.out.println("ECLAT: " + (itemset_size + 1) + "-th iteration");
			ArrayList<Set<Integer>> prev_iter_itemsets = m_found_itemsets.get(itemset_size-1);
			for( int idx1 = 0; idx1 < prev_iter_itemsets.size(); idx1++ ) {
				for( int idx2 = idx1 + 1; idx2 < prev_iter_itemsets.size(); idx2++ ) {
					Set<Integer> itemset1 = prev_iter_itemsets.get(idx1);
					Set<Integer> itemset2 = prev_iter_itemsets.get(idx2);
					if(!itemset1.equals(itemset2) && compatible(itemset1, itemset2)) {
						ArrayList<Integer> new_tidlist = join(m_itemsets.get(itemset1), m_itemsets.get(itemset2));
						Set<Integer> joined = new HashSet<Integer>(itemset1);
						joined.addAll(itemset2);
						if( new_tidlist.size() >= min_sup && !m_itemsets.containsKey(joined)) {
							m_found_itemsets.get(itemset_size).add(joined);
							m_itemsets.put(joined, new_tidlist);
							found = true;
						}
					}
				}
			}
		}
		return m_found_itemsets;
	}
	
	private boolean compatible(Set<Integer> itemset1, Set<Integer> itemset2) {
		if( itemset1.size() == 1 && itemset2.size() == 1) {
			return true;
		} else {
			HashSet<Integer> tmp = new HashSet<Integer>(itemset1);
			tmp.retainAll(itemset2);
			return tmp.size() == itemset1.size() - 1;
		}
	}
	
	private ArrayList<Integer> join(ArrayList<Integer> lst1, ArrayList<Integer> lst2) {
		int id1 = 0;
		int id2 = 0;
		ArrayList<Integer> joined = new ArrayList<Integer>();
		while(id1 < lst1.size() && id2 < lst2.size()) {
			if( lst1.get(id1) == lst2.get(id2)) {
				joined.add(lst1.get(id1));
				id1++;
				id2++;
			} else if( lst1.get(id1) < lst2.get(id2)) {
				id1++;
			} else if ( lst1.get(id1) > lst2.get(id2)) {
				id2++;
			}
		}
		return joined;
	}
	
	public String printItemset(Set<Integer> itemset) {
		String output = "{";
		for (int item : itemset) {
			output += m_catalog.getItemByID(item).name();
			output += ", ";
		}
		return output + "}";
	}
}
