package inheritance_and_polymorphism.class_problems;

abstract class Payment {
    double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double adjustedAmount();
    abstract String type();
}
class CardPayment extends Payment {
    CardPayment(double a) { super(a); }
    double adjustedAmount() { return amount * 1.02; }
    String type() { return "CARD"; }
}
class WalletPayment extends Payment {
    WalletPayment(double a) { super(a); }
    double adjustedAmount() { return amount * 1.01; }
    String type() { return "WALLET"; }
}
class BankTransferPayment extends Payment {
    BankTransferPayment(double a) { super(a); }
    double adjustedAmount() { return amount; }
    String type() { return "BANKTRANSFER"; }
}
public class Q1_PaymentSystem {
    public static void main(String[] args) {
        Payment[] payments = {new CardPayment(1000), new WalletPayment(500), new BankTransferPayment(2000)};
        double total = 0;
        for (Payment p : payments) {
            double value = p.adjustedAmount();
            System.out.printf("%s: %.2f%n", p.type(), value);
            total += value;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}