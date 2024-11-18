package com.syrency.lilyutil.containers.properties;

public interface Sized<T> {
    long size();
    boolean isEmpty();
    T[] toArray();

    default boolean isNotEmpty() {
        return !this.isEmpty();
    }
}
