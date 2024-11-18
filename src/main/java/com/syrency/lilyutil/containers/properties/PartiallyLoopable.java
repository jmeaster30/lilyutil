package com.syrency.lilyutil.containers.properties;

import com.syrency.lilyutil.exceptions.NoSuchElement;
import com.syrency.lilyutil.functions.Consumer;

import static com.syrency.lilyutil.exceptions.Exceptional.assertNoExcept;

// TODO This name is decent but unsure
public interface PartiallyLoopable<T> {
    boolean hasNext();
    T next() throws NoSuchElement;

    default void forEachRemaining(Consumer<T> action) {
        while (this.hasNext()) {
            action.consume(assertNoExcept(this::next).get());
        }
    }
}
