package com.syrency.lilyutil.composite;

import com.syrency.lilyutil.exceptions.NoSuchElement;
import com.syrency.lilyutil.functions.Function;
import com.syrency.lilyutil.functions.Functional;
import com.syrency.lilyutil.functions.Supplier;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Optional<T> {
    private final T value;
    private final boolean isEmpty;

    private Optional(@Nullable T item, boolean isEmpty) {
        this.value = item;
        this.isEmpty = isEmpty;
    }

    public T get() throws NoSuchElement {
        return this.value;
    }

    public T getOrDefault(T defaultValue) {
        if (this.isEmpty) return defaultValue;
        return this.value;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean isPresent() {
        return !this.isEmpty;
    }

    public <U> Optional<U> mapIfPresent(Function<T, U> mappingFunction) {
        return this.map(mappingFunction, Optional::empty);
    }

    public Optional<T> mapIfEmpty(Supplier<Optional<T>> supplier) {
        return this.map(Functional::identity, supplier);
    }

    public <U> Optional<U> map(Function<T, U> mapIfPresent, Supplier<Optional<U>> mapIfEmpty) {
        if (this.isEmpty) return mapIfEmpty.get();
        return Optional.of(mapIfPresent.call(this.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Optional<?> optional = (Optional<?>) o;
        return isEmpty == optional.isEmpty && Objects.equals(value, optional.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isEmpty);
    }

    public static <E> Optional<E> of(E item) {
        return new Optional<>(item, false);
    }

    public static <E> Optional<E> ofNullable(@Nullable E item) {
        return new Optional<>(item, item == null);
    }

    public static <E> Optional<E> empty() {
        return new Optional<>(null, true);
    }
}
