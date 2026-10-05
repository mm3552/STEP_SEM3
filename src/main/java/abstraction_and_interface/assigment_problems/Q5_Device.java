package abstraction_and_interface.assigment_problems;
interface Switchable { void turnOn(); void turnOff(); }
class Fan implements Switchable { public void turnOn(){System.out.println("Fan ON");} public void turnOff(){System.out.println("Fan OFF");} }
class Light implements Switchable { public void turnOn(){System.out.println("Light ON");} public void turnOff(){System.out.println("Light OFF");} }
public class Q5_Device { public static void main(String[] a){Switchable[] d={new Fan(),new Light()};for(Switchable x:d){x.turnOn();x.turnOff();}}}