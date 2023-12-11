package com.example.study.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {

    private int id;
    private String subject;
    private boolean isOpen;
}
