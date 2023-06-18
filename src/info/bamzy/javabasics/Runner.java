package info.bamzy.javabasics;

public class Runner {
    public static void main(String[] args){
        Shape r = new Rectangle();
        Shape t = new Triangle();

        System.out.println(r.introduce());
        System.out.println(t.introduce());
    }
}
