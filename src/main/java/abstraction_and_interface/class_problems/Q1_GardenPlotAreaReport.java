package abstraction_and_interface.class_problems;
import java.util.*;
abstract class Plot { String owner; Plot(String o){owner=o;} abstract double area(); abstract String shape(); }
class Circle extends Plot { double r; Circle(String o,double r){super(o);this.r=r;} double area(){return Math.PI*r*r;} String shape(){return "CIRCLE";} }
class Rectangle extends Plot { double l,w; Rectangle(String o,double l,double w){super(o);this.l=l;this.w=w;} double area(){return l*w;} String shape(){return "RECTANGLE";} }
class Triangle extends Plot { double b,h; Triangle(String o,double b,double h){super(o);this.b=b;this.h=h;} double area(){return .5*b*h;} String shape(){return "TRIANGLE";} }
public class Q1_GardenPlotAreaReport { public static void main(String[] a){Scanner s=new Scanner(System.in);int n=s.nextInt();double t=0;while(n-->0){String sh=s.next(),o=s.next();Plot p=sh.equals("CIRCLE")?new Circle(o,s.nextDouble()):sh.equals("RECTANGLE")?new Rectangle(o,s.nextDouble(),s.nextDouble()):new Triangle(o,s.nextDouble(),s.nextDouble());System.out.printf("%s (%s): %.2f%n",p.owner,p.shape(),p.area());t+=p.area();}System.out.printf("Total Area: %.2f%n",t);}}