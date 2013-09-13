package us.codecraft.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafter@gmail.com
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.parallelStream().distinct().forEach((t)->{
            System.out.println(t);});

    }
}
