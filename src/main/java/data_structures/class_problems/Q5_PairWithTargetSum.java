package data_structures.class_problems;
import java.util.*;
public class Q5_PairWithTargetSum {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();
  int target=sc.nextInt();HashSet<Integer> seen=new HashSet<>();boolean found=false;
  for(int x:a){if(seen.contains(target-x)){found=true;break;}seen.add(x);}
  System.out.println(found);System.out.println("HashSet: O(n) average time, O(n) space.");
  System.out.println("Brute force: O(n^2) time, O(1) extra space.");
 }
}