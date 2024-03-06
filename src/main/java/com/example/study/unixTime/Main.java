package com.example.study.unixTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.study.common.AnsiConst.*;

public class Main {
    public static void main(String[] args) {

//        ============ requestTime        : 2024-03-06 10:26:18 ==================
//        ============ startTimeMillis    : 1709687400000       ==================
//        ============ endTimeMillis      : 1709687700000       ==================
//        ============ endTime            : 2024-03-06T10:15    ==================

        String requestTime = "2024-03-06 10:26:18";
        long startTimeMillis = 1709687400000L; // 유닉스 타임스탬프 (밀리초 단위)
        long endTimeMillis   = 1709687700000L;
        String endTime = "2024-03-06T10:15"; // // ISO 8601 형식의 날짜와 시간


        System.out.println("=========== requestTime        : " + requestTime + " ==================");
        System.out.println("=========== startTimeMillis    : " + startTimeMillis + "       ==================");
        System.out.println("=========== endTimeMillis      : " + endTimeMillis + "       ==================");
        System.out.println("=========== endTime            : " + endTime + "    ==================");


        Instant instant = Instant.ofEpochMilli(startTimeMillis);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault()); // 원하는 다른 시간대를 사용하려면 ZoneId.of("시간대 ID")



        String startTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(zonedDateTime);

        String endTimeStr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(java.time.ZoneId.systemDefault()).format(java.time.Instant.ofEpochMilli(endTimeMillis));

        // 1. ISO 8601 형식을 LocalDateTime 객체로 파싱
        // 2. 원하는 형식으로 날짜와 시간을 포맷팅
        endTime = LocalDateTime.parse(endTime).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String logMsg = "\n" +
                ANSI_BLUE + "============================================================================\n" +
                ANSI_YELLOW + "Request Time     : " + ANSI_RESET + requestTime        + "\n" +
                ANSI_YELLOW + "startTimeMillis  : " + ANSI_RESET + startTime    + "\n" +
                ANSI_YELLOW + "endTimeMillis    : " + ANSI_RESET + endTimeStr      + "\n" +
                ANSI_YELLOW + "endTime          : " + ANSI_RESET + endTime            + "\n" +
                ANSI_BLUE + "============================================================================\n" + ANSI_RESET;


        System.out.println(logMsg);

//        ============================================================================
//        Request Time     :  2024-03-06 10:26:18
//        startTimeMillis  :  2024-03-06 10:10:00
//        endTimeMillis    :  2024-03-06 10:15:00
//        endTime          :  2024-03-06 10:15:00
//        ============================================================================
    }
}
