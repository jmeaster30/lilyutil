package com.syrency.lilyutil.containers.properties;

import com.syrency.lilyutil.composite.Optional;
import com.syrency.lilyutil.exceptions.IndexOutOfBounds;

public interface Indexable<T> {
    T get(int index) throws IndexOutOfBounds;
    Optional<Integer> indexOf(T item);
    Optional<Integer> lastIndexOf(T item);
}
