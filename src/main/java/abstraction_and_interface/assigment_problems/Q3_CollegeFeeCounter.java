package abstraction_and_interface.assigment_problems;
import java.util.*;
abstract class StudentFee { String name; StudentFee(String n){name=n;} abstract double fee(); boolean usesBus(){return false;} }
class DayScholar extends StudentFee { DayScholar(String n){super(n);} double fee(){return 40000+12000;} boolean usesBus(){return true;} }
class Hosteller extends StudentFee { Hosteller(String n){super(n);} double fee(){return 40000+60000;} }
class ScholarStudent extends StudentFee { ScholarStudent(String n){super(n);} double fee(){return 20000+12000;} boolean usesBus(){return true;} }
public class Q3_CollegeFeeCounter {
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();double total=0;
  while(n-->0){String t=s.next(),name=s.next();StudentFee x=t.equals("DAY_SCHOLAR")?new DayScholar(name):t.equals("HOSTELLER")?new Hosteller(name):new ScholarStudent(name);double f=x.fee();System.out.printf("%s: %.2f%n",name,f);total+=f;}
  System.out.printf("Total Collected: %.2f%n",total);
 }
}