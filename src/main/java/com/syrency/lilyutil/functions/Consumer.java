package com.syrency.lilyutil.functions;

@FunctionalInterface
public interface Consumer<T> {
    void consume(T a);
}

class ConsumerSample {
    public static void main(String[] args) {
        Consumer<Integer> print = System.out::println;
        print.consume(5);
    }
}
