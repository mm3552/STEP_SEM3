package data_structures.class_problems;
import java.util.*;
public class Q3_TransactionDuplicateCheck {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();HashSet<String> seen=new HashSet<>();boolean duplicate=false;
  for(int i=0;i<n;i++){String id=sc.next();if(!seen.add(id))duplicate=true;}
  System.out.println(duplicate);System.out.println("Time: O(n) average, Space: O(n)");
  System.out.println("Alternative: sorting takes O(n log n) time and less extra memory.");
 }
}