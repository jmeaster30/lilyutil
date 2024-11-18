package com.syrency.lilyutil.functions;

import com.syrency.lilyutil.containers.properties.PartiallyLoopable;

import static com.syrency.lilyutil.exceptions.Exceptional.assertNoExcept;

public class Functional {
    public static <T, U, V> Function<U, V> curry(BiFunction<T, U, V> func, T value) {
        return (U parameter) -> func.call(value, parameter);
    }

    public static <T> T identity(T a) {
        return a;
    }

    public static <T, U> U reduce(PartiallyLoopable<T> items, U initialValue, BiFunction<T, U, U> reducer) {
        U result = initialValue;
        while (items.hasNext()) {
            result = reducer.call(assertNoExcept(items::next).get(), result);
        }
        return result;
    }
}
