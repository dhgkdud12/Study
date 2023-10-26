package com.example.study.stream.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        // 등급, 점수로 그룹화

        List<Student> students = Arrays.asList(new Student("Tom", "A+", 90),
                new Student("Lisa", "A+", 98),
                new Student("John", "A", 85),
                new Student("Joe", "A", 80),
                new Student("Jason", "E", 35));


        Map<String, Double> studentByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.averagingInt(Student::getMarks)));

        for (Map.Entry<String, Double> entry: studentByGrade.entrySet()) {
            System.out.println("등급: " + entry.getKey() + ", 평균: " + entry.getValue());
        }

        

    }
}
