package abstraction_and_interface.class_problems;
import java.util.*;
abstract class Staff { String name; Staff(String n){name=n;} abstract double pay(); }
class FullTime extends Staff { double salary; FullTime(String n,double s){super(n);salary=s;} double pay(){return salary;} }
class Hourly extends Staff { double hours,rate; Hourly(String n,double h,double r){super(n);hours=h;rate=r;} double pay(){return Math.min(hours,40)*rate+Math.max(0,hours-40)*rate*1.5;} }
class Intern extends Staff { double stipend; Intern(String n,double s){super(n);stipend=s;} double pay(){return stipend;} }
public class Q2_WeeklyStaffPay { public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();double t=0;while(n-->0){String type=s.next(),name=s.next();Staff x=type.equals("FULLTIME")?new FullTime(name,s.nextDouble()):type.equals("HOURLY")?new Hourly(name,s.nextDouble(),s.nextDouble()):new Intern(name,s.nextDouble());System.out.printf("%s: %.2f%n",x.name,x.pay());t+=x.pay();}System.out.printf("Total Payroll: %.2f%n",t);}}