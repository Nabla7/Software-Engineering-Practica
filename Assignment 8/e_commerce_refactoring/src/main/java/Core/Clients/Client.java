package Core.Clients;

/**
 * Base class for a client containing all necessary information needed to place an order
 */
public class Client {
	private int m_cid;
	private static int m_next_id = 1;
	
	private String m_name;
	private Address m_address;
	
	/**
	 * Constructor
	 * 
	 * @param name	Name of the client
	 * @param address	Address of the client
	 */
	public Client(String name, Address address) {
		m_cid = m_next_id;
		m_next_id += 1;
		
		m_name = name;
		m_address = address;
	}
	
	/**
	 * Get ID of the client
	 * 
	 * @return ID
	 */
	public int ID() {
		return m_cid;
	}
	
	/**
	 * Get Name of the client
	 * 
	 * @return	Name
	 */
	public String name() {
		return m_name;
	}
	
	/**
	 * Get Address of the client
	 * 
	 * @return	Address
	 */
	public Address address() {
		return m_address;
	}
}
