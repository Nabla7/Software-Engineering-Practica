package Payment;

public class PaymentProcessor {
	
	ExternalPayments m_externalPayments;
	
	private static double m_cost_visa = 0.25;
	private static double m_cost_mastercard = 0.2;
	private static double m_cost_bancontact = 0.1;

	public PaymentProcessor(ExternalPayments externalPayment) {
		m_externalPayments = externalPayment;
	}
	
	public boolean pay(Payment payment) {
		boolean success = true;
		payment.m_state = PaymentState.OPEN;
		if (payment.m_type == "VISA") {
			payment.m_amount += m_cost_visa;
			if (m_externalPayments.visaPayment(payment)) {
				payment.m_state = PaymentState.SUCCEED;
			} else {
				payment.m_state = PaymentState.FAILED;
			}
		} else if (payment.m_type == "MASTERCARD") {
			payment.m_amount += m_cost_mastercard;
			if (m_externalPayments.mastercardPayment(payment)) {
				payment.m_state = PaymentState.SUCCEED;
			} else {
				payment.m_state = PaymentState.FAILED;
			}
		} else if (payment.m_type == "BANCONTACT") {
			payment.m_amount += m_cost_bancontact;
			if (m_externalPayments.bancontactPayment(payment)) {
				payment.m_state = PaymentState.SUCCEED;
			} else {
				payment.m_state = PaymentState.FAILED;
			}
		} else if (payment.m_type == "OFFLINE") {
			
		}
		
		return success;
	}
	
	public void setOfflinePayed(Payment payment) {
		if (payment.m_type == "OFFLINE") {
			payment.m_state = PaymentState.SUCCEED;
		}
	}
	
	public void cancelPayment(Payment payment) {
		payment.m_state = PaymentState.ABORTED;
	}
	
	public PaymentState getPaymentState(Payment payment) {
		return payment.m_state;
	}
}
