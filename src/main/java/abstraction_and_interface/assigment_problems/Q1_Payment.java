package abstraction_and_interface.assigment_problems;
interface Payable { double pay(); }
class CashPayment implements Payable { double amount; CashPayment(double a){amount=a;} public double pay(){return amount;} }
class CardPayment implements Payable { double amount; CardPayment(double a){amount=a;} public double pay(){return amount*1.02;} }
class WalletPayment implements Payable { double amount; WalletPayment(double a){amount=a;} public double pay(){return amount*1.01;} }
public class Q1_Payment { public static void main(String[] a){Payable[] p={new CashPayment(100),new CardPayment(100),new WalletPayment(100)};for(Payable x:p)System.out.printf("%.2f%n",x.pay());}}