package com.example.study.optional;

import java.util.Optional;

public class Person {
    private Optional<Car> car; // 사람이 차를 소유했을 수도, 소유하지 않았을 수도 있으므로 Optional로 정의
    public Optional<Car> getCar() {
        return car;
    }

    public class Car {
        private Optional<Insurance> insurance; // 자동차가 보험에 가입되어 있을 수도, 가입되어 있지 않았을 수도 있으므로 Optional로 정의
        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    public class Insurance {
        private String name; // 보험회사에는 이름이 반드시 있음
        public String getName() {
            return name;
        }
    }


}