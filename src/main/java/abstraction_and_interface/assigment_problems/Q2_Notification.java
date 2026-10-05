package abstraction_and_interface.assigment_problems;
interface Notifier { void send(String message); }
class EmailNotifier implements Notifier { public void send(String m){System.out.println("Email: "+m);} }
class SMSNotifier implements Notifier { public void send(String m){System.out.println("SMS: "+m);} }
public class Q2_Notification { public static void main(String[] a){Notifier[] n={new EmailNotifier(),new SMSNotifier()};for(Notifier x:n)x.send("Hello");}}