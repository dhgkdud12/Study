package com.example.study.builder;

public class Main {
    public static void main(String[] args) {

        Student student = new StudentBuilder()
                .id(2016120091)
                .name("홍길동")
                .grade("Senior")
                .phoneNumber("010-5555-5555")
                .build();

        System.out.println(student);
    }
}
