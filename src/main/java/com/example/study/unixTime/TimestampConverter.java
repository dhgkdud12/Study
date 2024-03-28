package com.example.study.unixTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.example.study.common.AnsiConst.*;

public class TimestampConverter {
    public static void main(String[] args) {

        // 타임스탬프 -> 날짜 형식

        long startTimeMillis = 1710035700000L; // 유닉스 타임스탬프 (밀리초 단위)
        long endTimeMillis   = 1710059700000L;


        String startTimeStr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault())
                .format(Instant.ofEpochMilli(startTimeMillis));
        String endTimeStr   = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault())
                .format(Instant.ofEpochMilli(endTimeMillis));

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String logMsg = "\n" +
                ANSI_BLUE + "============================================================================\n" +
                ANSI_YELLOW + "타임스탬프 -> 날짜 형식        : " + "\n" +
                ANSI_YELLOW + "Request Time              : " + ANSI_RESET + now             + "\n" +
                ANSI_YELLOW + "Transfer startTimeMillis  : " + ANSI_RESET + startTimeStr    + "\n" +
                ANSI_YELLOW + "Transfer endTimeMillis    : " + ANSI_RESET + endTimeStr      + "\n" +
                ANSI_BLUE + "============================================================================\n" + ANSI_RESET;


        System.out.println(logMsg);


        // 날짜 형식 -> LocalDateTime
        String dateStr = "2023-03-04 02:55:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(dateStr, formatter); // 2023-03-04T02:55

        String logMsg2 = "\n" +
                ANSI_BLUE + "============================================================================\n" +
                ANSI_YELLOW + "날짜 형식 -> LocalDateTime  : " + "\n" +
                ANSI_YELLOW + "time                      : " + ANSI_RESET + time     + "\n" +
                ANSI_BLUE + "============================================================================\n" + ANSI_RESET;


        System.out.println(logMsg2);

        // LocalDateTime ->
//        LocalDateTime now = LocalDateTime.parse("2024-03-04T02:55:00");


        System.out.println(LocalDateTime.now());
    }
}
