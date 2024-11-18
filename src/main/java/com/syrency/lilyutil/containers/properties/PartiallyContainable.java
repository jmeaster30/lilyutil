package com.syrency.lilyutil.containers.properties;

public interface PartiallyContainable<T> {
    // TODO add docs for this: No guarantees around how this method modifies the underlying class
    boolean contains(T item);
}
