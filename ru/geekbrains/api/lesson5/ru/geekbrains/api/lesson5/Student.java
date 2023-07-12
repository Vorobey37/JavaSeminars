package ru.geekbrains.api.lesson5;

public class Student {
    
    String name;
    String surName;
    double rating;

    public Student(String name, String surName, double rating){
        this.name = name;
        this.surName = surName;
        this.rating = rating;

    }

    @Override
    public String toString() {
        return surName + " " + name;
    }
}
