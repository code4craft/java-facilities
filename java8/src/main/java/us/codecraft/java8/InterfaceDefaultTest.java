package us.codecraft.java8;

/**
 * @author code4crafter@gmail.com
 */
public class InterfaceDefaultTest {

    public interface InterfaceDefault {

        default String getName(){
            return "interface";
        }
    }

    public static class Impl implements InterfaceDefault{

    }

    public static void main(String[] args) {
        System.out.println(new Impl().getName());
    }
}
