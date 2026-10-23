import Task1.OldPayGateway;
import Task1.PaymentProcessor;

public class PaymentAdapter implements PaymentProcessor {
    private OldPayGateway gateway;

    public PaymentAdapter(OldPayGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(String customerId, double amountInDollars) {
        int cents = (int) Math.round(amountInDollars * 100);
        gateway.chargeInCents(cents, customerId);
    }

    public static void main(String[] args) {
        String studentId = "240103123";
        System.out.println("Student ID: " + studentId);

        OldPayGateway old = new OldPayGateway();
        PaymentProcessor pp = new PaymentAdapter(old);

        pp.processPayment(studentId, 142.75);
    }
}