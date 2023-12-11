package com.example.study.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ex1 {
    public static void main(String[] args) {

        List<SchoolClass> programmingClass = new ArrayList<>();
        // Stream이 아닌 다른 종류형을 받을 수 있으면 종료형 operation이다
        programmingClass.add(new SchoolClass(1, "JSP programming", true));
        programmingClass.add(new SchoolClass(2, "C programming", true));
        programmingClass.add(new SchoolClass(3, "Java programming", false));
        programmingClass.add(new SchoolClass(4, "Android programming", false));
        programmingClass.add(new SchoolClass(5, "JavaScript programming", false));


         Optional<SchoolClass> optional = programmingClass.stream()
                 .filter(pc -> pc.getSubject().startsWith("Java"))
                 .findFirst();

        boolean present = optional.isPresent(); // 값이 있는지
        System.out.println(present);

        boolean check = optional.isEmpty(); // 값이 없는지
        System.out.println(check); 

        SchoolClass schoolClass = optional.get(); // Oprional이 감싸고 있는 type의 인스턴스 가져옴
        System.out.println(schoolClass.getSubject());

        if (optional.isPresent()) { // 값이 있는지 확인 후
            SchoolClass schoolClass1 = optional.get(); // 꺼내오기
            System.out.println(schoolClass1.getSubject());
        }

//        optional.isPresent(s -> System.out.println(schoolClass.getSubject()));

        SchoolClass schoolClass1 = optional.orElse(createNewClass()); // 값이 없는 경우
        System.out.println(schoolClass1.getSubject());

        SchoolClass schoolClass2 = optional.orElseGet(() -> createNewClass());
        SchoolClass schoolClass3 = optional.orElseGet(Ex1::createNewClass); // method reference

        SchoolClass schoolClass4 = optional.orElseThrow(() -> {
            return new IllegalArgumentException();
        });

        SchoolClass schoolClass5 = optional.orElseThrow(IllegalAccessError::new);

        optional.map(SchoolClass::getId); // 메소드 체이닝

        

    }

    public static SchoolClass createNewClass() {
        System.out.println("creating new school class");
        return new SchoolClass(9, "New Class", false);
    }
}
