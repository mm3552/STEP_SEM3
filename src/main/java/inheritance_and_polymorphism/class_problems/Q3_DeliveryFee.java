package inheritance_and_polymorphism.class_problems;

abstract class Delivery {
    double weight, distance;
    Delivery(double w, double d) { weight = w; distance = d; }
    abstract double fee();
    abstract String type();
}
class StandardDelivery extends Delivery {
    StandardDelivery(double w,double d){super(w,d);}
    double fee(){return 5+0.50*weight+0.10*distance;}
    String type(){return "STANDARD";}
}
class ExpressDelivery extends Delivery {
    ExpressDelivery(double w,double d){super(w,d);}
    double fee(){return 15+weight+0.20*distance;}
    String type(){return "EXPRESS";}
}
class InternationalDelivery extends Delivery {
    double customsFee;
    InternationalDelivery(double w,double d,double c){super(w,d);customsFee=c;}
    double fee(){return 25+2*weight+0.50*distance+customsFee;}
    String type(){return "INTERNATIONAL";}
}
public class Q3_DeliveryFee {
    public static void main(String[] args) {
        Delivery[] deliveries={new StandardDelivery(10,50),new ExpressDelivery(5,20),new InternationalDelivery(20,100,30)};
        double total=0;
        for(Delivery d:deliveries){double v=d.fee();System.out.printf("%s: %.2f%n",d.type(),v);total+=v;}
        System.out.printf("Total: %.2f%n",total);
    }
}