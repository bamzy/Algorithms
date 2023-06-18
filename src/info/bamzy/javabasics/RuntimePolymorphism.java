package info.bamzy.javabasics;

public class RuntimePolymorphism {


    public static void main(String args[]){
        Scooter b = new Scooter();//upcasting
        b.run();
        System.out.println(b.speed);
    }

}
