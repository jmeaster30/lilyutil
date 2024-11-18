package com.syrency.lilyutil.composite;

import org.jetbrains.annotations.Nullable;

public class Objects {
    public static boolean equals(@Nullable Object a, @Nullable Object b) {
        if (a == b) return true;
        if (a != null) return a.equals(b);
        return false;
    }

    public static int hash(Object... objects) {
        int hash = 7;
        for (Object obj : objects) {
            hash = 31 * hash + (obj == null ? 0 : obj.hashCode());
        }
        return hash;
    }
}
