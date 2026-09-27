package inheritance_and_polymorphism.assigment_problems;

abstract class Room {
    int units;
    Room(int u){units=u;}
    abstract double bill();
    abstract String type();
}
class SingleRoom extends Room {
    SingleRoom(int u){super(u);}
    double bill(){return 8*units;}
    String type(){return "SINGLE";}
}
class SharedRoom extends Room {
    int occupants;
    SharedRoom(int u,int o){super(u);occupants=o;}
    double bill(){return 6*units/(double)occupants;}
    String type(){return "SHARED";}
}
class ACRoom extends Room {
    ACRoom(int u){super(u);}
    double bill(){return 10*units+200;}
    String type(){return "AC";}
}
public class Q3_HostelElectricity {
    public static void main(String[] args) {
        Room[] r={new SingleRoom(120),new SharedRoom(150,3),new ACRoom(100)};
        double total=0;
        for(Room x:r){double a=x.bill();System.out.printf("%s: %.2f%n",x.type(),a);total+=a;}
        System.out.printf("Total: %.2f%n",total);
    }
}