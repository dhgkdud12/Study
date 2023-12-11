package com.example.study.dataStructure.set;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Ex2 {
    public static void main(String[] args) {

        // SortedSet - 엘리먼트들을 정렬된 순서로 저장

        SortedSet<String> sortedSet = new TreeSet<>();

        sortedSet.add("Elem5");
        sortedSet.add("Elem2");
        sortedSet.add("Elem4");
        sortedSet.add("Elem3");
        sortedSet.add("Elem1");

        for (String elem : sortedSet) {
            System.out.println(elem);
        }

        SortedSet<String> headSet = sortedSet.headSet("Elem3"); // 1~2
        System.out.println("Head Set");
        for (String elem : headSet) {
            System.out.println(elem);
        }

        SortedSet<String> tailSet = sortedSet.tailSet("Elem4"); // 4~5
        System.out.println("Tail Set");
        for (String elem : tailSet) {
            System.out.println(elem);
        }

        SortedSet<String> subSet = sortedSet.subSet("Elem2", "Elem5"); // 2~4
        System.out.println("Sub Set");
        for (String elem : subSet) {
            System.out.println(elem);
        }

        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());


    }
}
