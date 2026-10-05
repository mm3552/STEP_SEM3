package abstraction_and_interface.class_problems;
import java.util.*;
abstract class Booking { static final double FEE=50; double d; Booking(double x){d=x;} abstract double fare(); double total(){return fare()+FEE;} }
class BusBooking extends Booking { BusBooking(double d){super(d);} double fare(){return 2*d;} }
class TrainBooking extends Booking { TrainBooking(double d){super(d);} double fare(){return 1.5*d;} }
class FlightBooking extends Booking { FlightBooking(double d){super(d);} double fare(){return 2500+4*d;} }
public class Q5_TravelBookingWithCommonFee { public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();while(n-->0){String ty=s.next();double d=s.nextDouble();Booking b=ty.equals("BUS")?new BusBooking(d):ty.equals("TRAIN")?new TrainBooking(d):new FlightBooking(d);System.out.printf("%s: %.2f%n",ty,b.total());}}}