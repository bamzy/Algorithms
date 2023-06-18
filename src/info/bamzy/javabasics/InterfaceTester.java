package info.bamzy.javabasics;

public class InterfaceTester implements TestInterface{
    @Override
    public void test() {
        System.out.println();
    }
    public static void main(String args[]){
        InterfaceTester it = new InterfaceTester();
        it.test();
    }
}
