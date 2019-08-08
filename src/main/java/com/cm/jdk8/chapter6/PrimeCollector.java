package com.cm.jdk8.chapter6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 16:31
 */
public class PrimeCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    private boolean isPrime(List<Integer> primes, int param) {
        int paramRoot = (int) Math.sqrt((double) param);
        return takeWhile(primes, integer -> integer <= paramRoot).stream().noneMatch(p -> param % p == 0);
    }

    private List<Integer> takeWhile(List<Integer> primes, Predicate<Integer> p) {
        int i = 0;
        for (Integer item : primes) {
            if (!p.test(item)) {
                return primes.subList(0, i);
            }
            i++;
        }
        return primes;
    }

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {
            {
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> primes, Integer param) -> {
            primes.get(isPrime(primes.get(true), param)).add(param);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
