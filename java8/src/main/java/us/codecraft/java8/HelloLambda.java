package us.codecraft.java8;

/**
 * @author code4crafter@gmail.com
 */
public class HelloLambda {

    private static void hellolambda() {
        System.out.println("Hello lambda!");
    }

    public static void main(String[] args) {
        Runnable runnable = HelloLambda::hellolambda;
        runnable.run();
    }
}
