package com.example.study.reflection;

import javax.swing.plaf.PanelUI;

public abstract class Animal implements Eating {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String cry();
}
