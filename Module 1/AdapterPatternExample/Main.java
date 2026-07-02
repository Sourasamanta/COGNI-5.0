interface PaymentProcessor {
    void processPayment();
}

class DebitGateway {

    public void debitPayment() {
        System.out.println("Payment made using Debit Card.");
    }
}

class CreditGateway {

    public void creditPayment() {
        System.out.println("Payment made using Credit Card.");
    }
}

class UPIGateway {

    public void upiPayment() {
        System.out.println("Payment made using UPI.");
    }
}


class DebitAdapter implements PaymentProcessor {

    private DebitGateway debit;

    public DebitAdapter(DebitGateway debit) {
        this.debit = debit;
    }

    @Override
    public void processPayment() {
        debit.debitPayment();
    }
}

class CreditAdapter implements PaymentProcessor {

    private CreditGateway credit;

    public CreditAdapter(CreditGateway credit) {
        this.credit = credit;
    }

    @Override
    public void processPayment() {
        credit.creditPayment();
    }
}

class UPIAdapter implements PaymentProcessor {

    private UPIGateway upi;

    public UPIAdapter(UPIGateway upi) {
        this.upi = upi;
    }

    @Override
    public void processPayment() {
        upi.upiPayment();
    }
}

public class Main {

    public static void main(String[] args) {

        PaymentProcessor debit =
                new DebitAdapter(new DebitGateway());

        PaymentProcessor credit =
                new CreditAdapter(new CreditGateway());

        PaymentProcessor upi =
                new UPIAdapter(new UPIGateway());

        debit.processPayment();
        credit.processPayment();
        upi.processPayment();
    }
}
