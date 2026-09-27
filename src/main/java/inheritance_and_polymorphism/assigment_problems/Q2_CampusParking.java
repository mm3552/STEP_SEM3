package inheritance_and_polymorphism.assigment_problems;

abstract class Vehicle {
    int hours;
    Vehicle(int h){hours=h;}
    abstract double charge();
    abstract String type();
}
class Bike extends Vehicle {
    Bike(int h){super(h);}
    double charge(){return 10*hours;}
    String type(){return "BIKE";}
}
class Car extends Vehicle {
    Car(int h){super(h);}
    double charge(){return hours==1?30:30+20*(hours-1);}
    String type(){return "CAR";}
}
class Truck extends Vehicle {
    Truck(int h){super(h);}
    double charge(){return Math.max(50*hours,100);}
    String type(){return "TRUCK";}
}
public class Q2_CampusParking {
    public static void main(String[] args) {
        Vehicle[] v={new Bike(3),new Car(4),new Truck(1),new Car(1)};
        double total=0;
        for(Vehicle x:v){double a=x.charge();System.out.printf("%s: %.2f%n",x.type(),a);total+=a;}
        System.out.printf("Total: %.2f%n",total);
    }
}