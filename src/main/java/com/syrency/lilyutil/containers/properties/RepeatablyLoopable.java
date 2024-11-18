package com.syrency.lilyutil.containers.properties;

import com.syrency.lilyutil.functions.Consumer;
import com.syrency.lilyutil.functions.Function;

import static com.syrency.lilyutil.exceptions.Exceptional.assertNoExcept;

public interface RepeatablyLoopable<T> extends PartiallyLoopable<T> {
    enum LoopBehavior {
        CONTINUE,
        BREAK
    }

    void start();

    default void forEach(Consumer<T> action) {
        this.start();
        while (this.hasNext()) {
            action.consume(assertNoExcept(this::next).get());
        }
    }

    default void forEach(Function<T, LoopBehavior> action) {
        this.start();
        while (this.hasNext()) {
            LoopBehavior result = action.call(assertNoExcept(this::next).get());
            if (result == LoopBehavior.BREAK) {
                break;
            }
        }
    }
}
