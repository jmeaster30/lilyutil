package com.syrency.lilyutil.exceptions;

import com.syrency.lilyutil.functions.Consumer;
import com.syrency.lilyutil.functions.Supplier;
import com.syrency.lilyutil.functions.exceptable.ExceptableConsumer;
import com.syrency.lilyutil.functions.exceptable.ExceptableSupplier;

public class Exceptional {
    public static <T, E extends Throwable> Consumer<T> assertNoExcept(ExceptableConsumer<T, E> exceptableConsumer) {
        return (T a) -> {
            try {
                exceptableConsumer.consume(a);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T, E extends Throwable> Supplier<T> assertNoExcept(ExceptableSupplier<T, E> exceptableSupplier) {
        return () -> {
            try {
                return exceptableSupplier.get();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
