package com.example.study.lambda.ex1;

public class FuncInterfaceMain {
    public static void main(String[] args) {

        // 2. 매개변수가 1개인 경우
        FuncInterface func = null;

        func = (x) -> {
            int result = x * 5;
            System.out.println("result의 값 : " + result);
        };
        func.method(10);

        func = x -> System.out.println("result의 값 : " + (x * 5));
        func.method(20);


        // 3. 매개변수가 2개일 경우

        Func2Interface func2 = null;

        func2 = (x, y) -> {
            int result = x + y;
            return result;
        };
        System.out.println("#1 : " + func2.method(10, 100));

        // 약식 표현
        func2 = (x, y) -> { return x + y; };
        System.out.println("#2 " + func2.method(50, 100));

        func2 = (x, y) -> x + y;
        System.out.println("#3 " + func2.method(150, 100));

        func2 = (x, y) -> sum(x, y);
        System.out.println("#4 " + func2.method(250, 100));
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}
