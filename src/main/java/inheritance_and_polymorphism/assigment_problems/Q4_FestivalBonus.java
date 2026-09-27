package inheritance_and_polymorphism.assigment_problems;

abstract class Employee {
    String name; double salary;
    Employee(String n,double s){name=n;salary=s;}
    abstract double bonus();
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String n,double s){super(n,s);}
    double bonus(){return salary*.10;}
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String n,double s){super(n,s);}
    double bonus(){return salary*.05;}
}
class InternEmployee extends Employee {
    InternEmployee(String n,double s){super(n,s);}
    double bonus(){return 2000;}
}
public class Q4_FestivalBonus {
    public static void main(String[] args) {
        Employee[] e={new FullTimeEmployee("Asha",50000),new PartTimeEmployee("Ravi",30000),new InternEmployee("Neha",15000)};
        double total=0;
        for(Employee x:e){double b=x.bonus();System.out.printf("%s: %.2f%n",x.name,b);total+=b;}
        System.out.printf("Total Bonus: %.2f%n",total);
    }
}