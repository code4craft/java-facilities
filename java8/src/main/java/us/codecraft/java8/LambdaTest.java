package us.codecraft.java8;

import java.lang.reflect.Field;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author code4crafter@gmail.com
 */
public class LambdaTest {

    private static void bar() {
        System.out.println("bar");
    }

    private static void hellolambda() {
        System.out.println("Hello lambda!");
    }

    public static Supplier<Integer> testClosure() {
        int i = 1;
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return i;
            }
        };
        return null;
    }

    public static void main(String[] args) {

        Function<Integer,String> convert = String::valueOf;
        String s = convert.apply(1);

        Runnable runnable = LambdaTest::hellolambda;

//        Runnable runnable = () -> {
//            System.out.println("Hello lambda!");
//        };




        Supplier<Integer> integerSupplier = testClosure();

        Field[] declaredFields = integerSupplier.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }


        new Thread(LambdaTest::bar).start();

        //runnable
        new Thread(() -> {
            System.out.println("Foo");
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Foo");
            }
        }).start();

        //lambda
        Selector<Integer> selector = e -> {
            return e > 0;
        };

        int x = 0;
        R r = new R();
        new Thread(new R()::run).start();

        System.out.println(selector.select(1));

    }

    public static class R implements Runnable {

        @Override
        public void run() {

        }
    }

    @FunctionalInterface
    public static interface Selector<T> {

        public boolean select(T t);
    }

}
