package data_structures.class_problems;
import java.util.*;
public class Q4_EmployeeDepartmentLookup {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();HashMap<String,String> lookup=new HashMap<>();
  for(int i=0;i<n;i++){String id=sc.next(),dept=sc.next();lookup.put(id,dept);}
  int q=sc.nextInt();for(int i=0;i<q;i++){String id=sc.next();System.out.println(lookup.getOrDefault(id,"Unknown"));}
  System.out.println("Build: O(n) average, Query: O(1) average, Space: O(n)");
 }
}