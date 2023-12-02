package Core.Clients;

import java.util.HashMap;

/**
 * Class that keeps track of all registered clients
 */
public class Clients {
	
	HashMap<String, RegisteredClient> m_clients;
	HashMap<Integer, Client> m_all_clients;
	
	/**
	 * Constructor
	 */
	public Clients() {
		m_clients = new HashMap<String, RegisteredClient>();
		m_all_clients = new HashMap<Integer, Client>();
	}
	
	/**
	 * Add a new registered user to the system
	 * 
	 * @param client	New client to add
	 * @param username	Username used for login
	 */
	public void AddRegisteredClient(RegisteredClient client, String username) {
		m_clients.put(username, client);
	}
	
	/**
	 * Add an unregistered client to the system
	 * 
	 * @param client	New client to add
	 */
	public void AddUnregisteredClient(UnregisteredClient client) {
		m_all_clients.put(client.ID(), client);
	}
	
	/**
	 * Return the client that matches the given client ID
	 * 
	 * @param cid	The client's ID
	 * @return	Client
	 */
	public Client getClient(int cid) {
		return m_all_clients.get(cid);
	}
	
	/**
	 * Get the client that is linked to the given username and password.
	 * 
	 * @param username	Username
	 * @param password	Entered password, used for checking with stored hashed password
	 * @return	Client if username and password are correct. Null otherwise
	 */
	public Client getRegisteredClient(String username, String password) {
		if (m_clients.containsKey(username)) {
			RegisteredClient c = m_clients.get(username);
			if (c.checkPassword(password)) {
				return c;
			} else {
				System.out.println("Combination Username-Password does not occur in our database");
				return null;
			}
		} else {
			System.out.println("Combination Username-Password does not occur in our database");
			return null;
		}
	}
	
}
