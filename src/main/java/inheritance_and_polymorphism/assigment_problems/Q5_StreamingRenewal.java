package inheritance_and_polymorphism.assigment_problems;

import java.time.LocalDate;

abstract class Plan {
    String name; LocalDate startDate;
    Plan(String n,LocalDate d){name=n;startDate=d;}
    abstract int validityDays();
    LocalDate renewalDate(){return startDate.plusDays(validityDays());}
}
class BasicPlan extends Plan {
    BasicPlan(String n,LocalDate d){super(n,d);}
    int validityDays(){return 30;}
}
class StandardPlan extends Plan {
    StandardPlan(String n,LocalDate d){super(n,d);}
    int validityDays(){return 90;}
}
class PremiumPlan extends Plan {
    PremiumPlan(String n,LocalDate d){super(n,d);}
    int validityDays(){return 365;}
}
public class Q5_StreamingRenewal {
    public static void main(String[] args) {
        Plan[] p={new BasicPlan("Asha",LocalDate.of(2024,1,15)),new StandardPlan("Ravi",LocalDate.of(2024,2,1)),
            new PremiumPlan("Neha",LocalDate.of(2024,3,10)),new BasicPlan("Kiran",LocalDate.of(2024,12,20))};
        for(Plan x:p) System.out.println(x.name+": "+x.renewalDate());
    }
}