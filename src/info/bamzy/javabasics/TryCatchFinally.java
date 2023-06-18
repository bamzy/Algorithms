package info.bamzy.javabasics;

public class TryCatchFinally {
    public static void main(String []args){
        try{
            int a = 1;
            System.out.println(a/0);
        } catch(ArithmeticException ex){
            System.out.println("exc happened");
        } catch (Exception ex){
            System.out.println("another handler");
        }
        finally
        {
            System.out.println("rest of the code...");
        }
    }
}
