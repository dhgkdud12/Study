package com.example.study.lambda.ex1;

public class MyFunctionInterface {

    public static void main(String[] args) {
        // 1. 매개변수가 없을 경우
        MyFunctionalInterface func1 = new MyFunctionalInterface() {
            @Override
            public void method() {
                String str = "직접 익명구현객체 생성함";
                System.out.println(str);
            }
        };
        func1.method();

        func1 = () -> {
            String str = "람다식으로 익명구현객체 생성";
            System.out.println(str);
        };
        func1.method();

        func1 = () -> System.out.println("약식 람다식으로 익명구현객체 생성");
        func1.method();
    }
}
