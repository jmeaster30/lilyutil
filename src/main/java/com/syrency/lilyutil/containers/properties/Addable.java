package com.syrency.lilyutil.containers.properties;

import org.jetbrains.annotations.NotNull;

import static com.syrency.lilyutil.functions.Functional.reduce;

public interface Addable<T> {
    boolean add(T item);

    default boolean addAll(@NotNull PartiallyLoopable<T> items) {
        return reduce(items, false, (item, prev) -> this.add(item) || prev);
    }
}
