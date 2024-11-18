package com.syrency.lilyutil.containers.properties;

import org.jetbrains.annotations.NotNull;

import static com.syrency.lilyutil.functions.Functional.reduce;

public interface Containable<T> extends RepeatablyLoopable<T> {
    //  TODO add docs for this: INVARIANT Must NOT change the loopable index
    boolean contains(T item);

    default boolean containsAll(@NotNull PartiallyLoopable<T> items) {
        return reduce(items, true, (item, prev) -> this.contains(item) || prev);
    }
}
