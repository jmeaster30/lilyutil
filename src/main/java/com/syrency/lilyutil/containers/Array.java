package com.syrency.lilyutil.containers;

import com.syrency.lilyutil.composite.Objects;
import com.syrency.lilyutil.composite.Optional;
import com.syrency.lilyutil.containers.properties.*;
import com.syrency.lilyutil.exceptions.IndexOutOfBounds;
import com.syrency.lilyutil.exceptions.NoSuchElement;
import com.syrency.lilyutil.exceptions.NotImplemented;
import com.syrency.lilyutil.functions.Predicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.syrency.lilyutil.functions.Functional.curry;
import static com.syrency.lilyutil.functions.Predicate.predicate;

public class Array<T> implements RepeatablyLoopable<T>, Containable<T>, Sized<T>, Searchable<T>, Indexable<T>, Settable<T> {
    private final T[] internalArray;
    private int currentIndex;

    public Array(T[] array) {
        this.internalArray = array;
        this.currentIndex = -1;
    }

    @Override
    public T get(int index) throws IndexOutOfBounds {
        if (index < 0 || index >= this.internalArray.length) throw new IndexOutOfBounds();
        this.currentIndex = index;
        return this.internalArray[index];
    }

    @Override
    public Optional<Integer> indexOf(T item) {
        Optional<Integer> result = Optional.empty();
        for (int i = 0; i < this.size(); i++) {
            if (Objects.equals(item, this.internalArray[i])) {
                result = Optional.of(i);
                break;
            }
        }
        return result;
    }

    @Override
    public Optional<Integer> lastIndexOf(T item) {
        Integer result = null;
        for (int i = 0; i < this.size(); i++) {
            if (Objects.equals(item, this.internalArray[i])) {
                result = i;
            }
        }
        return Optional.ofNullable(result);
    }

    @Override
    public T set(int index, T value) throws IndexOutOfBounds {
        if (index < 0 || index >= this.internalArray.length) throw new IndexOutOfBounds();
        this.currentIndex = index;
        T oldValue = this.internalArray[this.currentIndex];
        this.internalArray[this.currentIndex] = value;
        return oldValue;
    }

    @Override
    public boolean contains(T needle) {
        return this.findFirst(predicate(curry(Objects::equals, needle))).isPresent();
    }

    @Override
    public void start() {
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex == this.internalArray.length - 1;
    }

    @Override
    public T next() throws NoSuchElement {
        if (!this.hasNext()) {
            throw new NoSuchElement();
        }
        return this.internalArray[this.currentIndex++];
    }

    @Override
    public long size() {
        return internalArray.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public T[] toArray() {
        return this.internalArray;
    }

    @Override
    public Optional<T> findFirst(Predicate<T> predicate) {
        Optional<T> result = Optional.empty();
        for (T value : this.internalArray) {
            if (predicate.call(value)) {
                result = Optional.of(value);
                break;
            }
        }
        return result;
    }

    @Override
    public PartiallyLoopable<T> findAll(Predicate<T> predicate) {
        throw new NotImplemented();
    }

    @SafeVarargs
    public static <T> @NotNull Array<T> of(T @NotNull ... values) {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[values.length];
        System.arraycopy(values, 0, newArray, 0, values.length);
        return new Array<>(newArray);
    }

    public static <T> @NotNull Array<T> ofSize(int size) {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[size];
        return new Array<>(newArray);
    }

    public static <T> @NotNull Array<T> ofSize(int size, @Nullable T defaultValue) {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = defaultValue;
        }
        return new Array<>(newArray);
    }
}
