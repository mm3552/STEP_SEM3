package data_structures.class_problems;
import java.util.*;
public class Q8_SpiralOrderTraversal {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int m=sc.nextInt(),n=sc.nextInt();int[][] a=new int[m][n];
  for(int i=0;i<m;i++)for(int j=0;j<n;j++)a[i][j]=sc.nextInt();
  int top=0,bottom=m-1,left=0,right=n-1;ArrayList<Integer> out=new ArrayList<>();
  while(top<=bottom&&left<=right){
   for(int j=left;j<=right;j++)out.add(a[top][j]);top++;
   for(int i=top;i<=bottom;i++)out.add(a[i][right]);right--;
   if(top<=bottom){for(int j=right;j>=left;j--)out.add(a[bottom][j]);bottom--;}
   if(left<=right){for(int i=bottom;i>=top;i--)out.add(a[i][left]);left++;}
  }
  System.out.println(out);System.out.println("Time: O(m*n), Output Space: O(m*n)");
 }
}