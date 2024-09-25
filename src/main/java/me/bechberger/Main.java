package me.bechberger;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {


    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @State(Scope.Thread)
    public static class ExtendedThreadInfoBenchmark {

        @Benchmark
        public void benchmarkGetAll() {
            Map<Long, ExtendedThreadInfo> threadInfoMap = ExtendedThreadInfo.getAll();
            // You can print or process the thread info if needed
            // System.out.println(threadInfoMap);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(ExtendedThreadInfoBenchmark.class.getSimpleName())
                .forks(1) // Number of forks
                .build();

        new Runner(options).run();
    }
}