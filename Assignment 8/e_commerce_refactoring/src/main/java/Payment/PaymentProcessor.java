package Payment;

public class PaymentProcessor {
	
	ExternalPayments m_externalPayments;
	

	public PaymentProcessor(ExternalPayments externalPayment) {
		m_externalPayments = externalPayment;
	}
	
	public boolean pay(Payment payment) {
		return payment.pay(m_externalPayments);
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
