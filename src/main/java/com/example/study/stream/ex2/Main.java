package com.example.study.stream.ex2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("[\\P{L}]+");
        long count = words.stream().filter(w -> w.length() > 12).count();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> doubleNumbers =
                numbers.stream().map(x -> x*2).collect(Collectors.toList());


        // 실습 1
        int result = numbers.stream().filter(i -> i > 3)
                .map(i -> i*2)
                .reduce(0, (x,y) -> x+y);

        System.out.println(result);


        Stream<String> strings = Stream.of("aa", "a", "aaa", "bbbbbbbbbbbbbbbbb", "CCCCCCCCCCCCCCCC", "CCCC", "CCCCCSSSSSSCCC");
        // 실습 2
        strings.filter(i -> i.length() > 12).sorted(Comparator.comparing(String::length).reversed())
                .distinct()
                .map(String::toLowerCase)
                .forEach(System.out::println);

    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }
}
