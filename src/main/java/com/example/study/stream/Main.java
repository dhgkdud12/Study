package com.example.study.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Camb");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambr");
        Trader brian = new Trader("Brian", "Cambrid");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 2011년에 일어난 모든 트랜잭션 오름차순
        List<Transaction> trs1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(Collectors.toList());

        // 거래자가 근무하는 모든 도시 중복없이 나열
        List<String> trs2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        // 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬
        List<Trader> trs3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());

        // 모든 거래자의 이름을 알파벳순으로 정리해서 반환
        String trs4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1+n2);

        // 밀라노에 거래자가 있는가?
        boolean trs5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Millano"));

        // 케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력
        // 모든 트랜잭션 값, 케임브리지에 거주하는 거래자
        List<Integer> trs6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        // 전체 트랜잭션 중 최댓값
        Optional<Integer> trs7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        if (trs7.isPresent()) {
            System.out.println(trs7.get());
        }

        // 전체 트랜잭션 중 최솟값
        Optional<Integer> trs8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        if (trs8.isPresent()) {
            System.out.println(trs8.get());
        }

    }
}
