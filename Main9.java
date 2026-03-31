package Task9;
interface Payment {
    void pay(double amount);
}
class OnlinePayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using online payment.");
    }
}
class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in cash.");
    }
}
class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public void generateInvoice() {
        System.out.println("Invoice generated for amount: $" + amount);
    }

    public double getAmount() {
        return amount;
    }
}
abstract class Order {
    protected String orderId;
    protected Invoice invoice; // Composition

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.invoice = new Invoice(amount);
    }

    public abstract void processOrder();

    public void showInvoice() {
        invoice.generateInvoice();
    }
}
class OnlineOrder extends Order {
    private Payment payment;

    public OnlineOrder(String orderId, double amount, Payment payment) {
        super(orderId, amount);
        this.payment = payment;
    }

    @Override
    public void processOrder() {
        System.out.println("Processing online order: " + orderId);
        payment.pay(invoice.getAmount());
    }
}
class StoreOrder extends Order {
    private Payment payment;

    public StoreOrder(String orderId, double amount, Payment payment) {
        super(orderId, amount);
        this.payment = payment;
    }

    @Override
    public void processOrder() {
        System.out.println("Processing store order: " + orderId);
        payment.pay(invoice.getAmount());
    }
}


public class Main9 {
        public static void main(String[] args) {

            Payment onlinePay = new OnlinePayment();
            Payment cashPay = new CashPayment();

            Order o1 = new OnlineOrder("ORD101", 500.0, onlinePay);
            Order o2 = new StoreOrder("ORD102", 300.0, cashPay);

            o1.processOrder();
            o1.showInvoice();

            o2.processOrder();
            o2.showInvoice();
        }
}
