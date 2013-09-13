package us.codecraft.java8;

/**
 * @author code4crafter@gmail.com
 */
@FunctionalInterface
public interface Selector<T> {

    public boolean select(T t);
}
