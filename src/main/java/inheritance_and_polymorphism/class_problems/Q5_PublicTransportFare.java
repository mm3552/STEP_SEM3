package inheritance_and_polymorphism.class_problems;

abstract class Transport {
    double distance;
    Transport(double d){distance=d;}
    abstract double fare();
    abstract String type();
}
class Bus extends Transport {
    Bus(double d){super(d);}
    double fare(){return Math.min(2+0.10*distance,10);}
    String type(){return "BUS";}
}
class Train extends Transport {
    Train(double d){super(d);}
    double fare(){return 3+0.15*distance;}
    String type(){return "TRAIN";}
}
class Metro extends Transport {
    double factor;
    Metro(double d,double f){super(d);factor=f;}
    double fare(){return (1.50+0.20*distance)*factor;}
    String type(){return "METRO";}
}
public class Q5_PublicTransportFare {
    public static void main(String[] args) {
        Transport[] t={new Bus(15),new Train(50),new Metro(10,1.5)};
        double total=0;
        for(Transport x:t){double v=x.fare();System.out.printf("%s: %.2f%n",x.type(),v);total+=v;}
        System.out.printf("Total: %.2f%n",total);
    }
}