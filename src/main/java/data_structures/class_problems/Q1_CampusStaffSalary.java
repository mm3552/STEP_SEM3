package data_structures.class_problems;
import java.util.*;
public class Q1_CampusStaffSalary {
 static class Staff {String name;double base;Staff(String n,double b){name=n;base=b;}double bonus(){return 0;}String type(){return "Staff";}}
 static class Teacher extends Staff {Teacher(String n,double b){super(n,b);}double bonus(){return 5000;}String type(){return "Teacher";}}
 static class LabAssistant extends Staff {LabAssistant(String n,double b){super(n,b);}double bonus(){return 2000;}String type(){return "LabAssistant";}}
 public static void main(String[] args){Scanner s=new Scanner(System.in);int n=s.nextInt();Staff[] a=new Staff[n];for(int i=0;i<n;i++){String t=s.next(),name=s.next();double b=s.nextDouble();a[i]=t.equals("Teacher")?new Teacher(name,b):t.equals("LabAssistant")?new LabAssistant(name,b):new Staff(name,b);}double total=0;for(Staff x:a){double sum=x.base+x.bonus();System.out.println(x.name+" ("+x.type()+"): base "+x.base+", bonus "+x.bonus()+", total "+sum);total+=sum;}System.out.println("Grand Total Salary: "+total);}
}