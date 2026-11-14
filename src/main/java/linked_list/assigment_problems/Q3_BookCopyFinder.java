package linked_list.assigment_problems;
import java.util.*;
public class Q3_BookCopyFinder {
 static class Node {String data;Node next;Node(String d){data=d;}}
 static void find(Node h,String id){int pos=1,first=-1,count=0;while(h!=null){if(h.data.equals(id)){if(first==-1)first=pos;count++;}h=h.next;pos++;}if(first==-1)System.out.println(id+" not found");else System.out.println(id+" first at position "+first+", copies: "+count);}
 public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();Node h=null,t=null;for(int i=0;i<n;i++){Node x=new Node(s.next());if(h==null)h=x;else t.next=x;t=x;}find(h,s.next());}
}