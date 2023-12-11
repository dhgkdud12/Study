package com.example.study.stream.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student
{
    private String name;
    private String grade;
    private int score;

    Student(String name, String grade, Integer score)
    {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public String getName() { return name; }
    public String getGrade() { return grade; }
    public int getMarks() { return score; }

    @Override
    public String toString() { return getName(); }

}