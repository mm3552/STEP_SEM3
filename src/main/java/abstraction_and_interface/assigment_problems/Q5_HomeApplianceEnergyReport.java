package abstraction_and_interface.assigment_problems;
import java.util.*;
abstract class Appliance { double hours; Appliance(double h){hours=h;} abstract double power(); boolean saverSupported(){return false;} double units(){return power()*hours/1000;} }
class Fridge extends Appliance { Fridge(double h){super(h);} double power(){return 150;} }
class AC extends Appliance { AC(double h){super(h);} double power(){return 1500;} boolean saverSupported(){return true;} }
class TV extends Appliance { TV(double h){super(h);} double power(){return 100;} }
class Washer extends Appliance { Washer(double h){super(h);} double power(){return 500;} boolean saverSupported(){return true;} }
public class Q5_HomeApplianceEnergyReport {
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();double total=0;
  while(n-->0){String t=s.next();double h=s.nextDouble();boolean saver=s.hasNext("SAVER")&&s.next().equals("SAVER");Appliance a=t.equals("FRIDGE")?new Fridge(h):t.equals("AC")?new AC(h):t.equals("TV")?new TV(h):new Washer(h);
   if(saver&&!a.saverSupported()){System.out.println(t+": saver mode not supported");continue;}
   double u=a.units()*(saver?.75:1),c=u*8;System.out.printf("%s: Units=%.2f Cost=%.2f%n",t,u,c);total+=c;
  } System.out.printf("Total Cost: %.2f%n",total);
 }
}