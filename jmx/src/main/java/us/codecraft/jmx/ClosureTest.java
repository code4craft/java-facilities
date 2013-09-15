package us.codecraft.jmx;

import java.lang.reflect.Field;

/**
 * @author code4crafter@gmail.com
 */
public class ClosureTest {


    public static Supplier<Integer> testClosure(){
        final int i = 1;
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Supplier<Integer> integerSupplier = testClosure();
        Field[] declaredFields = integerSupplier.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }


    public interface Supplier<T> {

        T get();
    }
}
