package Payment;

import Core.Order;

public class Payment {

	public PaymentState m_state;
	public double m_amount;
	public Order m_order;
	public String m_type;	
	private double m_paymentCost;
	
	public Payment(double amount, Order order, String type) {
		m_amount = amount;
		m_order = order;
		m_type = type;
		m_state = PaymentState.STARTED;
	}

	public double getPaymentCost() {
		return m_paymentCost;
	}

	private void updatePaymentAmount(double cost) {
	payment.m_amount += cost;
}

	public boolean pay(ExternalPayments externalPayments) {
		boolean success = true;
		m_state = PaymentState.OPEN;
		updatePaymentAmount(getPaymentCost());
		switch (m_type) {
			case "VISA":
				if (externalPayments.visaPayment(this)) {
					m_state = PaymentState.SUCCEED;
				} else {
					m_state = PaymentState.FAILED;
				}
				break;
			case "MASTERCARD":
				if (externalPayments.mastercardPayment(this)) {
					m_state = PaymentState.SUCCEED;
				} else {
					m_state = PaymentState.FAILED;
				}
				break;
			case "BANCONTACT":
				if (externalPayments.bancontactPayment(this)) {
					m_state = PaymentState.SUCCEED;
				} else {
					m_state = PaymentState.FAILED;
				}
				break;
		}
	}
}

public class VISAPayment extends Payment {

	public VISAPayment(double amount, Order order) {
		super(amount, order, "VISA");
		m_paymentCost = 0.25;
	}
}

public class MasterCardPayment extends Payment {

	public MasterCardPayment(double amount, Order order) {
		super(amount, order, "MASTERCARD");
		m_paymentCost = 0.2;
	}
}

public class BancontactPayment extends Payment {

	public BancontactPayment(double amount, Order order) {
		super(amount, order, "BANCONTACT");
		m_paymentCost = 0.1;
	}
}

public class OfflinePayment extends Payment {

	public OfflinePayment(double amount, Order order) {
		super(amount, order, "OFFLINE");
	}
}


