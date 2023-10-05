package com.example.study.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ex1 {
    public static void main(String[] args) {

        // Collection Factory
        List<String> cars = new ArrayList<>();
        cars.add("아반테");
        cars.add("소나타");
        cars.add("그렌저");

        List<String> cars2 = Arrays.asList("아반테", "소나타", "그랜저");

        Stream<String> car = cars2.stream();
        car.forEach(s -> System.out.println(s));
    }
}
