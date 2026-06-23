package com.example.benchmarks;

import com.example.userservice.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class JsonSerializationBenchmark {

    private ObjectMapper objectMapper;
    private User user;

    @Setup
    public void setup() {
        objectMapper = new ObjectMapper();
        user = new User("testuser", "test@mail.ru", 1L);
        user.setId(1L);
    }

    @Benchmark
    public byte[] serializeToJson() throws Exception {
        return objectMapper.writeValueAsBytes(user);
    }

    @Benchmark
    public User deserializeFromJson() throws Exception {
        byte[] json = objectMapper.writeValueAsBytes(user);
        return objectMapper.readValue(json, User.class);
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(JsonSerializationBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}