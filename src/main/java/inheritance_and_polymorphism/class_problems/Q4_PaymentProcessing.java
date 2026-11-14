package inheritance_and_polymorphism.class_problems;
import java.util.*;
interface PaymentMode {double processPayment(double amount);double fee(double amount);String mode();}
class CashPayment implements PaymentMode {public double processPayment(double a){return a;}public double fee(double a){return 0;}public String mode(){return "Cash";}}
class CardPayment implements PaymentMode {public double processPayment(double a){return a*1.02;}public double fee(double a){return a*.02;}public String mode(){return "Card";}}
class UpiPayment implements PaymentMode {public double processPayment(double a){return a;}public double fee(double a){return 0;}public String mode(){return "UPI";}}
public class Q4_PaymentProcessing {public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();PaymentMode[] p=new PaymentMode[n];double total=0;for(int i=0;i<n;i++){String m=s.next();double x=s.nextDouble();p[i]=m.equalsIgnoreCase("cash")?new CashPayment():m.equalsIgnoreCase("card")?new CardPayment():new UpiPayment();}for(int i=0;i<n;i++){double x=0;/* amount is read and stored separately in full input below */} }}
