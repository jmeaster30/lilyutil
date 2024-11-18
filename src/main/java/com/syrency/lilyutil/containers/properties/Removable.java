package com.syrency.lilyutil.containers.properties;

import org.jetbrains.annotations.NotNull;

import static com.syrency.lilyutil.functions.Functional.reduce;

public interface Removable<T> {
    boolean remove(T item);

    default boolean removeAll(@NotNull PartiallyLoopable<T> items) {
        return reduce(items, false, (item, prev) -> this.remove(item) || prev);
    }
}
