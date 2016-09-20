package java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunnerStream {

    public static final String SPLITTER = "------------------------------------";

    public static void main(String[] args) {
        orderInParallel();
        mapping();
        mappingWithResultCollection();
        find();
        filter();
        peek();
        matching();
        sorting();
        skip();
        unique();
        minmax();
        reduce();
    }

    private static void reduce() {
        System.out.println(SPLITTER);
        System.out.println("example of stream reduce");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(25);
        System.out.println("collection: " + numbers);
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        System.out.println(SPLITTER);
    }

    private static void minmax() {
        System.out.println(SPLITTER);
        System.out.println("example of stream min max");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbersRandom(25).stream().sorted().collect(Collectors.toList());
        System.out.println("collection: " + numbers);
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println("min: " + min.get());
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println("max: " + max.get());
        System.out.println(SPLITTER);
    }

    private static void unique() {
        System.out.println(SPLITTER);
        System.out.println("example of stream distinct");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbersRandom(25).stream().sorted().collect(Collectors.toList());
        System.out.println("collection: " + numbers);
        List<Integer> unique = numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("unique elements: " + unique);
        System.out.println(SPLITTER);
    }

    private static void skip() {
        System.out.println(SPLITTER);
        System.out.println("example of stream skip");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(25);
        System.out.println("collection: " + numbers);
        List<Integer> skipped = numbers.stream().skip(20).collect(Collectors.toList());
        System.out.println("skip 20 elements: " + skipped);
        System.out.println(SPLITTER);
    }

    private static void sorting() {
        System.out.println(SPLITTER);
        System.out.println("example of stream sorting");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbersRandom(25);
        System.out.println("collection: " + numbers);
        System.out.print("ordered: ");
        numbers.stream().sorted().forEach(i -> System.out.print(i + " "));
        System.out.print("\nordered in parallel: ");
        numbers.parallelStream().sorted().forEach(i -> System.out.print(i + " "));
        System.out.print("\nordered in parallel strict: ");
        numbers.parallelStream().sorted().forEachOrdered(i -> System.out.print(i + " "));
        System.out.println("\n" + SPLITTER);
    }

    private static void matching() {
        System.out.println(SPLITTER);
        System.out.println("example of stream matching");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(25);
        System.out.println("collection: " + numbers);
        boolean allMatch = numbers.stream().allMatch(i -> i >= 0);
        System.out.println("all positive numbers: " + allMatch);
        boolean anyMatch = numbers.stream().anyMatch(i -> i > 25);
        System.out.println("there is a number > 25: " + anyMatch);
        boolean nonMatch = numbers.stream().noneMatch(i -> i > 25);
        System.out.println("there is no number > 25: " + nonMatch);
        System.out.println(SPLITTER);
    }

    private static void peek() {
        System.out.println(SPLITTER);
        System.out.println("example of stream filtering with additional actions");
        System.out.println(SPLITTER);
        List<String> collected = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(collected);
        System.out.println(SPLITTER);
    }

    private static void filter() {
        System.out.println(SPLITTER);
        System.out.println("example of stream filtering");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(25);
        System.out.println("collection: " + numbers);
        numbers = numbers.stream().filter(i -> i > 20).collect(Collectors.toList());
        System.out.println("filtered: " + numbers);
        System.out.println(SPLITTER);
    }

    private static void find() {
        System.out.println(SPLITTER);
        System.out.println("example of stream find element");
        System.out.println(SPLITTER);
        Set<Integer> numbers = initNumbersRandom(25).stream().collect(Collectors.toSet());
        System.out.println("collection: " + numbers);
        Optional<Integer> first = numbers.parallelStream().findFirst();
        System.out.println("first:" + first.get());
        Optional<Integer> any = numbers.parallelStream().findAny();
        System.out.println("any:" + any.get());
        numbers.clear();
        Optional<Integer> notFound = numbers.stream().findFirst();
        try {
            System.out.println("first of empty:" + notFound.get());
        } catch (NoSuchElementException e) {
            System.out.println("is present in empty:" + notFound.isPresent());
        }
        System.out.println(SPLITTER);
    }

    private static void mappingWithResultCollection() {
        System.out.println(SPLITTER);
        System.out.println("example of stream converting to other collection");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(25);
        List<String> collected = numbers.stream().map(i -> "n" + i).collect(Collectors.toList());
        System.out.println("converted result:" + collected);
        System.out.println(SPLITTER);
    }

    private static void mapping() {
        System.out.println(SPLITTER);
        System.out.println("example of stream mapping from Integer type to String");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(33);
        numbers.stream().map(i -> "n" + i).forEach(System.out::print);
        System.out.println("\n" + SPLITTER);
    }

    private static void orderInParallel() {
        System.out.println(SPLITTER);
        System.out.println("example of stream foreach and parallel foreach");
        System.out.println(SPLITTER);
        List<Integer> numbers = initNumbers(100);
        System.out.println("to string: " + numbers);
        System.out.print("stream: ");
        numbers.stream().forEach(i -> System.out.print(i + " "));
        System.out.print("\nparallel stream: ");
        numbers.parallelStream().forEach(i -> System.out.print(i + " "));
        System.out.println("\n" + SPLITTER);
    }

    private static List<Integer> initNumbers(int n) {
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> initNumbersRandom(int n) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(random.nextInt(n));
        }
        return numbers;
    }

}
