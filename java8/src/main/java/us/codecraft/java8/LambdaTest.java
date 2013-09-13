package us.codecraft.java8;

/**
 * @author code4crafter@gmail.com
 */
public class LambdaTest {

    public static void main(String[] args) {

        //runnable
        new Thread(() -> {
            System.out.println("Foo");
        }).start();

        //lambda
        Selector<Integer> selector = (e) -> {
            return e > 0;
        };

        int x = 0;

        System.out.println(selector.select(1));

    }

    @FunctionalInterface
    public static interface Selector<T> {

        public boolean select(T t);
    }

}
