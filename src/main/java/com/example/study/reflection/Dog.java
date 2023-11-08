package com.example.study.reflection;

public class Dog extends Animal implements Movable{

    private int age;

    public Dog(String name) {
        super(name);
    }

    @Override
    public String cry() {
        return "Bark";
    }

    @Override
    public String eats() {
        return "feed";
    }

    @Override
    public String move() {
        return "run";
    }

    public String wag() {
        return "wag tail";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
