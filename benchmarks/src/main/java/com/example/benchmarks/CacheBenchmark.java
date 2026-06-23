package com.example.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class CacheBenchmark {

    private ConcurrentHashMap<Long, String> cache;
    private long key;

    @Setup
    public void setup() {
        cache = new ConcurrentHashMap<>();
        for (long i = 0; i < 1000; i++) {
            cache.put(i, "value-" + i);
        }
        key = 500;
    }

    @Benchmark
    public String cacheGet() {
        return cache.get(key);
    }

    @Benchmark
    public String cachePut() {
        return cache.put(System.nanoTime() % 1000, "new-value");
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(CacheBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}