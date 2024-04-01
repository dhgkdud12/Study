package com.example.study.atomic;

public class CASAlogorithm {

    // CAS(compare and swap) 알고리즘
    // V : 업데이트될 변수(메모리 값)
    // e : 이전 예상 값
    // n : 업데이트될 예상값

    // V이 E의 값과 같으면 V는 N으로 설정됨
    // V의 값이 E의 값과 다르면 다른 스레드가 업데이트 되었음을 의미, 현재 스레드는 아무것도 하지 않고 현재 V의 실제 값 반환
    // 전체 작업이 원자성 띄고 있음, Non-Blocking 알고리즘

    private static CompareAndSwap cas = new CompareAndSwap();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    // Get estimates
                    int expectedValue = cas.get();
                    boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                    System.out.println(b);
                }
            });
        }

    }
}

class CompareAndSwap {
    private int value;

    // Get memory value
    public synchronized int get() {
        return value;
    }

    // Comparison
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        // Read memory value
        int oldValue = value;
        // Comparison
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    // Settings
    public synchronized boolean compareAndSet (int expectedValue, int newValue) {
        return (expectedValue == compareAndSwap(expectedValue, newValue));
    }
}