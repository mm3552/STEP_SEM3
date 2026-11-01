package data_structures.class_problems;
import java.util.*;
public class Q10_RemoveDuplicatesSortedArray {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();
  if(n==0){System.out.println("Length = 0");return;}
  int k=1;for(int i=1;i<n;i++)if(a[i]!=a[k-1])a[k++]=a[i];
  System.out.println("Length = "+k);System.out.print("Unique elements: ");
  for(int i=0;i<k;i++)System.out.print(a[i]+" ");
  System.out.println();System.out.println("Time: O(n), Extra Space: O(1)");
 }
}