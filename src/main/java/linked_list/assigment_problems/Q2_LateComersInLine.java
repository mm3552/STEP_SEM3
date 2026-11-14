package linked_list.assigment_problems;
import java.util.*;
public class Q2_LateComersInLine {
 static class Node {String data;Node next;Node(String d){data=d;}}
 static Node addFirst(Node h,String n){Node x=new Node(n);x.next=h;return x;}
 static Node addLast(Node h,String n){Node x=new Node(n);if(h==null)return x;Node p=h;while(p.next!=null)p=p.next;p.next=x;return h;}
 static void print(Node h){while(h!=null){System.out.print(h.data+" -> ");h=h.next;}System.out.println("null");}
 public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();Node h=null;for(int i=0;i<n;i++)h=addLast(h,s.next());int q=s.nextInt();for(int i=0;i<q;i++){String op=s.next(),name=s.next();if(op.equals("FIRST"))h=addFirst(h,name);else h=addLast(h,name);}print(h);}
}