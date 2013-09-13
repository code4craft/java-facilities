package us.codecraft.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author code4crafter@gmail.com
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(1);
        intList.add(2);

        //convert integers to strings
        List<String> strings = intList.stream()
                .map(String::valueOf)
                .collect(Collectors.<String>toList());

        strings.stream().forEach((e) -> {
            System.out.println(e + " " + e.getClass());
        });

        //get sum of all integer
        Integer sum = intList.stream().reduce((i, j) -> {
            return i + j;
        }).get();

        System.out.println(sum);

    }
}
