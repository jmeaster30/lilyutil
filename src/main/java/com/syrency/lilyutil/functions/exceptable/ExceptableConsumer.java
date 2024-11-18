package com.syrency.lilyutil.functions.exceptable;

@FunctionalInterface
public interface ExceptableConsumer<T, E extends Throwable> {
    void consume(T a) throws E;
}
