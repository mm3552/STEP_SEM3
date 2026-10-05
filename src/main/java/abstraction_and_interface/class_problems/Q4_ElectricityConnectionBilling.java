package abstraction_and_interface.class_problems;
import java.util.*;
abstract class Connection { int units; Connection(int u){units=u;} abstract double bill(); }
class Home extends Connection { Home(int u){super(u);} double bill(){return Math.min(units,100)*5+Math.max(0,units-100)*7;} }
class Shop extends Connection { Shop(int u){super(u);} double bill(){return 8*units+100;} }
class Factory extends Connection { Factory(int u){super(u);} double bill(){return Math.max(6*units,1000);} }
public class Q4_ElectricityConnectionBilling { public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();double t=0;while(n-->0){String ty=s.next();Connection c=ty.equals("HOME")?new Home(s.nextInt()):ty.equals("SHOP")?new Shop(s.nextInt()):new Factory(s.nextInt());double b=c.bill();System.out.printf("%s: %.2f%n",ty,b);t+=b;}System.out.printf("Total: %.2f%n",t);}}