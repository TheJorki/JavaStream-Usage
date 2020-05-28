package com.company;

public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{"+
                " Name : "+"\'"+getName()+"\'"
                +" Age : "+getAge()+
                " Gender : "+getGender()+"}";
    }
}
