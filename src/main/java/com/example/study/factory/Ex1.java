package com.example.study.factory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {

        // List
        List<String> cars1 = new ArrayList<>();
        cars1.add("아반테");
        cars1.add("소나타");
        cars1.add("그렌저");


        // Array.asList() 팩토리 메서드 이용
        List<String> cars2 = Arrays.asList("아반테", "소나타", "그랜저");

        Stream<String> car = cars2.stream();
        car.forEach(s -> System.out.println(s));

        // Set 컬렉션 생성
        Set<String> cars = new HashSet<>(cars2);
        Set<String> carStreams = Stream.of("아반테", "소나타", "그랜저").collect(Collectors.toSet());

        // 컬렉션 팩토리(Collection Factory)

        // 리스트 팩토리(List Factory)
        List<String> cars3 = List.of("아반테", "소나타", "그랜저");

        // 집합 팩토리(Set Factory)
        Set<String> overlapCars = Set.of("아반테", "소나타", "그랜저");

        // 맵 팩토리(Map Factory)
        // 요소의 개수가 적을 때
        Map<String, String> carInfo1 = Map.of("name", "아반테", "price", "23,000,000", "options", "2.0 Engine, SunRoof");

        // 그 이상의 맵을 만들 때
        Map<String, String> carInfo2 = Map.ofEntries(
                Map.entry("name", "아반테"),
                Map.entry("price", "23,000,000"),
                Map.entry("options", "2.0 Engine, SunRoof")
        );

        carInfo2.forEach((k, v) -> System.out.println(k + " " + v));
        carInfo2.entrySet().stream()
                .forEach(entry -> System.out.println("key: "+entry.getKey() + "value: " + entry.getValue()));
    }
}
