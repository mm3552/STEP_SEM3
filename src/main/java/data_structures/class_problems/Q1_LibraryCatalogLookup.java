package data_structures.class_problems;
import java.util.*;
public class Q1_LibraryCatalogLookup {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt(); String[] isbn=new String[n], title=new String[n];
  for(int i=0;i<n;i++){isbn[i]=sc.next();title[i]=sc.next();}
  String target=sc.next(); int low=0,high=n-1,found=-1;
  while(low<=high){int mid=(low+high)/2;int c=isbn[mid].compareTo(target);
   if(c==0){found=mid;break;} else if(c<0)low=mid+1;else high=mid-1;}
  System.out.println(found==-1?"Not Found":title[found]);
  System.out.println("Time: O(log n), Space: O(1)");
 }
}