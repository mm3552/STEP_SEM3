package abstraction_and_interface.assigment_problems;
import java.util.*;
abstract class Seat { static final double FEE=20; int count; Seat(int c){count=c;} abstract double price(); double total(){return count*(price()+FEE);} }
class RegularSeat extends Seat { RegularSeat(int c){super(c);} double price(){return 150;} }
class PremiumSeat extends Seat { PremiumSeat(int c){super(c);} double price(){return 250;} }
class ReclinerSeat extends Seat { ReclinerSeat(int c){super(c);} double price(){return 400;} }
public class Q1_MovieTicketCounter {
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();double total=0;
  while(n-->0){String type=s.next();int count=s.nextInt();Seat x=type.equals("REGULAR")?new RegularSeat(count):type.equals("PREMIUM")?new PremiumSeat(count):new ReclinerSeat(count);double a=x.total();System.out.printf("%s: %.2f%n",type,a);total+=a;}
  System.out.printf("Total: %.2f%n",total);
 }
}