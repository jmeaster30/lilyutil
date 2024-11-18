package com.syrency.lilyutil.containers.properties;

import com.syrency.lilyutil.composite.Optional;
import com.syrency.lilyutil.functions.Predicate;

public interface Searchable<T> extends RepeatablyLoopable<T> {
    Optional<T> findFirst(Predicate<T> predicate);
    PartiallyLoopable<T> findAll(Predicate<T> predicate);
}
