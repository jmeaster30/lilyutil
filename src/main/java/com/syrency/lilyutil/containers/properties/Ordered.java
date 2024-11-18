package com.syrency.lilyutil.containers.properties;

public interface Ordered<T> {
    boolean lessThan(T other);
    boolean greaterThan(T other);

    default boolean lessThanEqual(T other) {
        return !this.greaterThan(other);
    }

    default boolean greaterThanEqual(T other) {
        return !this.lessThan(other);
    }
}
