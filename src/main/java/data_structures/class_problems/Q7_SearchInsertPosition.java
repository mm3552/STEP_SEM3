package data_structures.class_problems;
import java.util.*;
public class Q7_SearchInsertPosition {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();
  int target=sc.nextInt(),low=0,high=n-1,answer=n;
  while(low<=high){int mid=(low+high)/2;if(a[mid]>=target){answer=mid;high=mid-1;}else low=mid+1;}
  System.out.println("Index = "+answer);System.out.println("Time: O(log n), Space: O(1)");
 }
}