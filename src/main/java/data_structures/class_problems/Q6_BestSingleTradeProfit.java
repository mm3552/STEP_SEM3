package data_structures.class_problems;
import java.util.*;
public class Q6_BestSingleTradeProfit {
 public static void main(String[] args){
  Scanner sc=new Scanner(System.in);int n=sc.nextInt();int min=Integer.MAX_VALUE,profit=0;
  for(int i=0;i<n;i++){int price=sc.nextInt();if(price<min)min=price;else if(price-min>profit)profit=price-min;}
  System.out.println("Maximum Profit = "+profit);
  System.out.println("Single scan: O(n) time, O(1) space; checking all pairs: O(n^2) time.");
 }
}