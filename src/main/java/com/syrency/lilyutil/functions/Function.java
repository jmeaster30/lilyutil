package com.syrency.lilyutil.functions;

@FunctionalInterface
public interface Function<T, U> {
    U call(T a);
}
