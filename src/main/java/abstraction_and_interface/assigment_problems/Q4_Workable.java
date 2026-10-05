package abstraction_and_interface.assigment_problems;
interface Workable { void work(); }
interface Eatable { void eat(); }
class Employee implements Workable,Eatable { public void work(){System.out.println("Employee works");} public void eat(){System.out.println("Employee eats");} }
public class Q4_Workable { public static void main(String[] a){Employee e=new Employee();e.work();e.eat();}}