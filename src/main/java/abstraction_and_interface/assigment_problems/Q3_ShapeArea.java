package abstraction_and_interface.assigment_problems;
interface Shape { double area(); }
class CircleShape implements Shape { double r; CircleShape(double r){this.r=r;} public double area(){return Math.PI*r*r;} }
class RectangleShape implements Shape { double l,w; RectangleShape(double l,double w){this.l=l;this.w=w;} public double area(){return l*w;} }
public class Q3_ShapeArea { public static void main(String[] a){Shape[] s={new CircleShape(5),new RectangleShape(4,6)};for(Shape x:s)System.out.printf("%.2f%n",x.area());}}