package com.syrency.lilyutil.functions.exceptable;

@FunctionalInterface
public interface ExceptableSupplier<T, E extends Throwable> {
    T get() throws E;
}
