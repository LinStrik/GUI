package pl.damian.Transform;

@FunctionalInterface
public interface Transform<T, R> {

    R[] apply(T[] in);


}
