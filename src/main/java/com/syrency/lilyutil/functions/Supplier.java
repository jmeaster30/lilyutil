package com.syrency.lilyutil.functions;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

class SupplierSample {
    public static void main(String[] args) {
        Supplier<Integer> five = () -> 5;
        System.out.println(five.get());
    }
}
