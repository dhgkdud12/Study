package com.example.study.unixTime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OnedayTest {
    public static void main(String[] args) {

        // 1. 현재 시간이나 날짜 가져오기
        // 2. 어제의 시작 시간과 끝 시간 구하기

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now : " + now);

        // 어제의 시작 시간 계산 (자정)
        LocalDateTime startOfYesterday = LocalDate.now().minusDays(1).atStartOfDay();

        // 어제의 끝 시간 계산 (23:59:59)
        LocalDateTime endOfYesterday = startOfYesterday.plusDays(1).minusSeconds(1);

        // 결과 출력
        System.out.println("어제의 시작 시간: " + startOfYesterday);
        System.out.println("어제의 끝 시간: " + endOfYesterday);

    }
}
