package com.example.study.lambda.ex2;

import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {

        // 예제 1
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
           arr[i] = getRandomNumber(i);
        }

        Arrays.setAll(arr, i -> (int)(Math.random()*5) + 1);
    }

    public static int getRandomNumber(int i) {
        return (int) (Math.random() * 5) + 1;
    }

    // 예제 2
    public int sumArr(int[] arr) {
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return sum;
    }

//    int[] arr -> { int sum = 0; for ( int i : arr ) sum += i; return sum; }




}
