package linked_list.assigment_problems;
import java.util.*;
public class Q1_BusRouteStops {
 static class Node { String data; Node next; Node(String d){data=d;} }
 static Node build(String[] stops){Node head=null,tail=null;for(String s:stops){Node x=new Node(s);if(head==null)head=x;else tail.next=x;tail=x;}return head;}
 static void printRoute(Node h){int count=0;String first="",last="";Node p=h;while(p!=null){if(count==0)first=p.data;last=p.data;System.out.print(p.data+" -> ");count++;p=p.next;}System.out.println("null");System.out.println("Stops: "+count+", First: "+first+", Last: "+last);}
 public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();String[] v=new String[n];for(int i=0;i<n;i++)v[i]=s.next();printRoute(build(v));}
}