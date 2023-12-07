package Payment;

import Core.Order;

public class Payment {

	public PaymentState m_state;
	public double m_amount;
	public Order m_order;
	public String m_type;	
	
	public Payment(double amount, Order order, String type) {
		m_amount = amount;
		m_order = order;
		m_type = type;
		m_state = PaymentState.STARTED;
	}
}
