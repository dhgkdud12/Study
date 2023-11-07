package com.example.study.dataStructure.map;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ex3 {
    public static void main(String[] args) {

        SortedMap sortedMap = new TreeMap();

        sortedMap.put("a", "one");
        sortedMap.put("b", "two");
        sortedMap.put("c", "three");

        Iterator iterator = sortedMap.keySet().iterator();

        while (iterator.hasNext()) {
            String key = (String) iterator.next();

            String value = (String) sortedMap.get(key);

            System.out.println(key + " " + value);
        }
    }
}
