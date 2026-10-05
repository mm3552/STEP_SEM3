package abstraction_and_interface.assigment_problems;
import java.util.*;
abstract class Cab { double km; Cab(double k){km=k;} abstract double rate(); double fare(){return Math.max(100,km*rate());} boolean nightService(){return false;} }
class MiniCab extends Cab { MiniCab(double k){super(k);} double rate(){return 10;} }
class SedanCab extends Cab { SedanCab(double k){super(k);} double rate(){return 14;} boolean nightService(){return true;} }
class SUVCab extends Cab { SUVCab(double k){super(k);} double rate(){return 18;} boolean nightService(){return true;} }
public class Q4_CityCabFareMeter {
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();double total=0;
  while(n-->0){String t=s.next();double km=s.nextDouble(),f;String time=s.next();Cab c=t.equals("MINI")?new MiniCab(km):t.equals("SEDAN")?new SedanCab(km):new SUVCab(km);
   if(time.equals("NIGHT")&&!c.nightService()){System.out.println(t+": night service not available");continue;}
   f=c.fare()*(time.equals("NIGHT")?1.2:1);System.out.printf("%s: %.2f%n",t,f);total+=f;
  } System.out.printf("Total: %.2f%n",total);
 }
}