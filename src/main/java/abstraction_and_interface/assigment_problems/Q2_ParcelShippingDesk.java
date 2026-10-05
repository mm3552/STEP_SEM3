package abstraction_and_interface.assigment_problems;
import java.util.*;
abstract class Parcel { double weight,value; Parcel(double w,double v){weight=w;value=v;} abstract double charge(); double insurance(){return 0;} }
class StandardParcel extends Parcel { StandardParcel(double w,double v){super(w,v);} double charge(){return 40+10*weight;} }
interface Insurable { double insurance(); }
class ExpressParcel extends Parcel implements Insurable { ExpressParcel(double w,double v){super(w,v);} public double insurance(){return .02*value;} double charge(){return 80+15*weight;} }
class FragileParcel extends Parcel implements Insurable { FragileParcel(double w,double v){super(w,v);} public double insurance(){return .02*value;} double charge(){return 40+10*weight+50;} }
public class Q2_ParcelShippingDesk {
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();double grand=0;
  while(n-->0){String t=s.next();double w=s.nextDouble(),v=s.nextDouble();Parcel p=t.equals("STANDARD")?new StandardParcel(w,v):t.equals("EXPRESS")?new ExpressParcel(w,v):new FragileParcel(w,v);double ins=p.insurance(),total=p.charge()+ins;System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",t,p.charge(),ins,total);grand+=total;}
  System.out.printf("Grand Total: %.2f%n",grand);
 }
}