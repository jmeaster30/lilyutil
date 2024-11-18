package com.syrency.lilyutil.functions;

@FunctionalInterface
public interface Predicate<T> extends Function<T, Boolean> {
    Boolean call(T a);

    static <T, U extends Boolean> Predicate<T> predicate(Function<T, U> func) {
        @SuppressWarnings("unchecked")
        Predicate<T> predicate = (Predicate<T>) func;
        return predicate;
    }
}
