package com.syrency.lilyutil.functions;

@FunctionalInterface
public interface BiFunction<T, U, V> {
    V call(T a, U b);
}
