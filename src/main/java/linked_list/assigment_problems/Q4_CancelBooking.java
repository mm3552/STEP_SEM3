package linked_list.assigment_problems;
import java.util.*;
public class Q4_CancelBooking {
 static class Node {String data;Node next;Node(String d){data=d;}}
 static Node removeFirst(Node h,String key){if(h==null){System.out.println(key+" not found");return h;}if(h.data.equals(key))return h.next;Node p=h;while(p.next!=null&&!p.next.data.equals(key))p=p.next;if(p.next==null)System.out.println(key+" not found");else p.next=p.next.next;return h;}
 static void print(Node h){while(h!=null){System.out.print(h.data+" -> ");h=h.next;}System.out.println("null");}
 public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();Node h=null,t=null;for(int i=0;i<n;i++){Node x=new Node(s.next());if(h==null)h=x;else t.next=x;t=x;}h=removeFirst(h,s.next());print(h);}
}