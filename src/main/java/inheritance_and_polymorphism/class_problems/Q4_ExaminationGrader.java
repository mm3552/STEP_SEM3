package inheritance_and_polymorphism.class_problems;

abstract class Question {
    String type, correctAnswer, studentAnswer;
    double points;
    Question(String t,String c,String s,double p){type=t;correctAnswer=c;studentAnswer=s;points=p;}
    abstract double score();
}
class MCQQuestion extends Question {
    MCQQuestion(String c,String s,double p){super("MCQ",c,s,p);}
    double score(){return studentAnswer.equalsIgnoreCase(correctAnswer)?points:0;}
}
class TFQuestion extends Question {
    TFQuestion(String c,String s,double p){super("TF",c,s,p);}
    double score(){return studentAnswer.equalsIgnoreCase(correctAnswer)?points:0;}
}
class EssayQuestion extends Question {
    EssayQuestion(String c,String s,double p){super("ESSAY",c,s,p);}
    double score(){
        String a=studentAnswer.toLowerCase(); int found=0;
        for(String k:correctAnswer.split(",")) if(a.contains(k.trim().toLowerCase())) found++;
        return found>=2?points*.75:found==1?points*.50:0;
    }
}
public class Q4_ExaminationGrader {
    public static void main(String[] args) {
        Question[] q={new MCQQuestion("Paris","Paris",10),new TFQuestion("False","True",5),
            new EssayQuestion("Inheritance, Polymorphism, Encapsulation","Polymorphism is one.",20),
            new EssayQuestion("Abstraction, Composition","I talked about abstraction.",15)};
        double total=0;
        for(Question x:q){double v=x.score();System.out.printf("%s: %.2f%n",x.type,v);total+=v;}
        System.out.printf("Total Score: %.2f%n",total);
    }
}