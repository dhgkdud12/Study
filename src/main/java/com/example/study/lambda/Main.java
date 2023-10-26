package com.example.study.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // 람다 input arguments -> body
        numbers.forEach((Integer value) -> System.out.println(value));
        numbers.forEach(value -> System.out.println(value));
        numbers.forEach(System.out::println);

    }
}
