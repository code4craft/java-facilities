package us.codecraft.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author code4crafter@gmail.com
 */
public class FunctionTest {

    private static void apply(Function<String, String> function) {
        System.out.println(function.apply("function "));
    }

    private static void supply(Supplier<String> supplier) {
        System.out.println("supply "+supplier.get());
    }

    public String foo(String param) {
        return param + "foo";
    }

    public String bar(String param) {
        return param + "bar";
    }

    public String foo() {
        return "foo";
    }

    public String bar() {
        return "bar";
    }

    public static void twoWay(Supplier<String> supplier, Consumer<String> consumer) {
        consumer.accept("two way " + supplier.get());
    }

    public static void biFunction(BiFunction<String,String,String> biFunction) {
        System.out.println(biFunction.apply("foo","bar"));
    }

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();

        apply(functionTest::foo);
        apply(functionTest::bar);

        supply(functionTest::foo);
        supply(functionTest::bar);

        twoWay(functionTest::foo, System.out::println);
        twoWay(functionTest::bar, System.out::println);

        biFunction("foo bar foo bar"::replace);
    }
}
