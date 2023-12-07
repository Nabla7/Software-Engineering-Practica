package Core.Clients;

/**
 * Class representing an unregistered client, contains only necessary information
 */
public class UnregisteredClient extends Client {

	/**
	 * Constructor
	 * 
	 * @param name	Client's name
	 * @param address	Client's address
	 */
	public UnregisteredClient(String name, Address address) {
		super(name, address);
	}
}
