package linked_list.assigment_problems;
import java.util.*;
public class Q5_PlateStackOnChain {
 static class Node {String data;Node next;Node(String d){data=d;}}
 static Node top=null;static int size=0;
 static void push(String x){Node n=new Node(x);n.next=top;top=n;size++;System.out.println("push "+x+" -> top "+top.data+", size "+size);}
 static void pop(){if(top==null)System.out.println("pop -> stack is empty");else{String x=top.data;top=top.next;size--;System.out.println("pop -> "+x+", size "+size);}}
 static void peek(){System.out.println(top==null?"peek -> stack is empty":"peek -> "+top.data);}
 public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();for(int i=0;i<n;i++){String op=s.next();if(op.equals("push"))push(s.next());else if(op.equals("pop"))pop();else if(op.equals("peek"))peek();else System.out.println("isEmpty -> "+(top==null));}}
}