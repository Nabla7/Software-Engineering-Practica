package Core.Clients;

/**
 * Class containing logic for representing and storing an address.
 */
public class Address {
	
	private String m_street;
	private String m_number;
	private String m_code;
	private String m_town;

	/**
	 * Constructor
	 * 
	 * @param street	Streetname of address
	 * @param number	Number (as String because of additions of letters)
	 * @param code		Postal code for town
	 * @param town		Town
	 */
	public Address(String street, String number, String code, String town) {
		m_street = street;
		m_number = number;
		m_code = code;
		m_town = town;
	}
	
	/**
	 * Get the address on a single line, for printing on goods before shipping. 
	 * 
	 * @return	Address as string
	 */
	public String getFullAddress() {
		return m_street + " " + m_number + " " + m_code + " " + m_town;
	}
}
