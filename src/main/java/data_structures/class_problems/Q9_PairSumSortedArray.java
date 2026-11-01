package data_structures.class_problems;
import java.util.*;
public class Q9_PairSumSortedArray {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();
  int target=sc.nextInt(),l=0,r=n-1;boolean found=false;
  while(l<r){int sum=a[l]+a[r];if(sum==target){System.out.println("("+a[l]+", "+a[r]+")");found=true;break;}else if(sum<target)l++;else r--;}
  if(!found)System.out.println("Not Found");
  System.out.println("Two pointers: O(n) time, O(1) space; unsorted brute force: O(n^2) time.");
 }
}