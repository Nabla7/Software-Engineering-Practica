package Payment;

public interface ExternalPayments {
	
	public boolean visaPayment(Payment payment);
	
	public boolean mastercardPayment(Payment payment);
	
	public boolean bancontactPayment(Payment payment);
}
