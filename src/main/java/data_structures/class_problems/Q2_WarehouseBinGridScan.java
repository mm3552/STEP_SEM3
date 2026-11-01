package data_structures.class_problems;
import java.util.*;
public class Q2_WarehouseBinGridScan {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int m=sc.nextInt(),n=sc.nextInt();
  int total=0,max=-1,row=0,col=0;
  for(int i=0;i<m;i++)for(int j=0;j<n;j++){int x=sc.nextInt();total+=x;if(x>max){max=x;row=i;col=j;}}
  System.out.println("Total = "+total);System.out.println("Maximum = "+max);
  System.out.println("Coordinate = ("+row+", "+col+")");
  System.out.println("Time: O(m*n), Extra Space: O(1)");
 }
}