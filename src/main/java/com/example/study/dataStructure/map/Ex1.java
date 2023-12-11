package com.example.study.dataStructure.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex1 {
    public static void main(String[] args) {

        // NavigableMap
        Map map = new TreeMap<>();
        SortedMap sortedMap = new TreeMap();
        NavigableMap navigableMap = new TreeMap();

        String grade;
        int point = 94;

        // if - else 구문 사용
        if (point >= 90)
            grade = "수";
        else if (point >= 80)
            grade = "우";
        else if (point >= 80)
            grade = "미";
        else if (point >= 80)
            grade = "양";
        else
            grade = "가";
        
        System.out.println("Grade : " + grade);
        
        // NavigableMap 사용
        NavigableMap<Integer, String> map1 = new TreeMap<>();
        map1.put(100, "수");
        map1.put(89, "우");
        map1.put(79, "미");
        map1.put(69, "양");
        map1.put(59, "가");

        String grade1 = map1.ceilingEntry(90).getValue(); // 입력받은 키 값보다 큰 방향으로 가장 인접한 키의 엔트리 리턴
        System.out.println("Grade : " + grade1);

    }
}
