package inheritance_and_polymorphism.assigment_problems;

abstract class Customer {
    double amount;
    Customer(double a){amount=a;}
    abstract double finalAmount();
    abstract String type();
}
class StudentCustomer extends Customer {
    StudentCustomer(double a){super(a);}
    double finalAmount(){return amount*.90;}
    String type(){return "STUDENT";}
}
class StaffCustomer extends Customer {
    StaffCustomer(double a){super(a);}
    double finalAmount(){return amount*.95;}
    String type(){return "STAFF";}
}
class GuestCustomer extends Customer {
    GuestCustomer(double a){super(a);}
    double finalAmount(){return amount+10;}
    String type(){return "GUEST";}
}
public class Q1_CanteenBilling {
    public static void main(String[] args) {
        Customer[] c={new StudentCustomer(200),new StaffCustomer(300),new GuestCustomer(150)};
        double total=0;
        for(Customer x:c){double v=x.finalAmount();System.out.printf("%s: %.2f%n",x.type(),v);total+=v;}
        System.out.printf("Total: %.2f%n",total);
    }
}