package com.syrency.lilyutil.containers.properties;

import com.syrency.lilyutil.exceptions.IndexOutOfBounds;

public interface Settable<T> extends Indexable<T> {
    T set(int index, T value) throws IndexOutOfBounds;
}
