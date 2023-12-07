package Core.Clients;

/**
 * Class containing all the preferences from a client regarding receiving e-mails
 *
 */
public class Mailing_Preferences {
	
	private boolean m_newsletters;
	private boolean m_promotions;
	private boolean m_third_party;
	
	/**
	 * Constructor
	 * 
	 * @param newsletters	Client wants to receive the monthly newsletters
	 * @param promotions	Client wants to receive promotional e-mails
	 * @param third_party	Client allows us to send him offers from third parties
	 */
	public Mailing_Preferences(boolean newsletters, boolean promotions, boolean third_party) {
		m_newsletters = newsletters;
		m_promotions = promotions;
		m_third_party = third_party;
	}
	
	/**
	 * Checks if client wants newletters
	 * 
	 * @return boolean
	 */
	public boolean newsletters() {
		return m_newsletters;
	}
	
	/**
	 * Checks if client wants promotions
	 * 
	 * @return boolean
	 */
	public boolean promotions() {
		return m_promotions;
	}
	
	/**
	 * Checks if client allows for third party e-mails
	 * 
	 * @return boolean
	 */
	public boolean third_party() {
		return m_third_party;
	}
}
