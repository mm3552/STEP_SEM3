package abstraction_and_interface.class_problems;
import java.util.*;
abstract class Item { String title; int days; Item(String t,int d){title=t;days=d;} abstract double fine(); }
class Book extends Item { Book(String t,int d){super(t,d);} double fine(){return 2*days;} }
class DVD extends Item { DVD(String t,int d){super(t,d);} double fine(){return Math.min(5*days,50);} }
class Magazine extends Item { Magazine(String t,int d){super(t,d);} double fine(){return days;} }
public class Q3_LibraryLateFineCounter { public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();double t=0;while(n-->0){String ty=s.next(),title=s.next();Item x=ty.equals("BOOK")?new Book(title,s.nextInt()):ty.equals("DVD")?new DVD(title,s.nextInt()):new Magazine(title,s.nextInt());System.out.printf("%s: %.2f%n",x.title,x.fine());t+=x.fine();}System.out.printf("Total Fines: %.2f%n",t);}}