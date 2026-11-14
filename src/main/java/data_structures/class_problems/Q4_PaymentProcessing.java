package data_structures.class_problems;
import java.util.*;
public class Q4_PaymentProcessing {
 interface PaymentMode {double processPayment(double amount);double fee(double amount);String mode();}
 static class CashPayment implements PaymentMode {public double processPayment(double a){return a;}public double fee(double a){return 0;}public String mode(){return "Cash";}}
 static class CardPayment implements PaymentMode {public double processPayment(double a){return a*1.02;}public double fee(double a){return a*.02;}public String mode(){return "Card";}}
 static class UpiPayment implements PaymentMode {public double processPayment(double a){return a;}public double fee(double a){return 0;}public String mode(){return "UPI";}}
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();PaymentMode[] p=new PaymentMode[n];double[] amounts=new double[n];for(int i=0;i<n;i++){String m=s.next();amounts[i]=s.nextDouble();p[i]=m.equalsIgnoreCase("cash")?new CashPayment():m.equalsIgnoreCase("card")?new CardPayment():new UpiPayment();}double total=0;for(int i=0;i<n;i++){double f=p[i].fee(amounts[i]),v=p[i].processPayment(amounts[i]);System.out.println(p[i].mode()+": amount "+amounts[i]+", fee "+f+", processed "+v);total+=v;}System.out.println("Total Amount Processed: "+total);}
}