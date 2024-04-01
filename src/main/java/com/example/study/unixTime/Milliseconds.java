package com.example.study.unixTime;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.example.study.common.AnsiConst.ANSI_RESET;
import static com.example.study.common.AnsiConst.ANSI_YELLOW;

@Slf4j
public class Milliseconds {
    public static void main(String[] args) {

//        Origin startTimeMillis : 1710060000000 Origin endTimeMillis : 1710060300000
//        startTimeMillis : 1710059400000 endTimeMillis : 1710059700000


        long OriginStartTimeMillis = 1710255600000L;
        long OriginEndTimeMillis   = 1710060300000L;

        long startTimeMillis       = 1710059400000L; // 유닉스 타임스탬프 (밀리초 단위)
        long endTimeMillis         = 1710059700000L;

        String logMsg =
                ANSI_YELLOW +
                "\n" +
                "============================================================================\n" +
                "Origin startTimeMillis : " + convertMillisToDate(OriginStartTimeMillis)  + "\n" +
                "Origin endTimeMillis   : " + convertMillisToDate(OriginEndTimeMillis)    + "\n" +
                "startTimeMillis        : " + convertMillisToDate(startTimeMillis)        + "\n" +
                "endTimeMillis          : " + convertMillisToDate(endTimeMillis)          + "\n"+
                "============================================================================\n"
                + ANSI_RESET
                ;

        log.info(logMsg);
    }

    public static String convertMillisToDate(long millis) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault())
                .format(Instant.ofEpochMilli(millis));
    }
}
