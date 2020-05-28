package com.company;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {

    public static void main(String[] args) {
        List<Person> people=getPeople();

        //Imperative approach
        List<Person> females=new ArrayList<>();
        for(Person person:people){
            if(person.getGender().equals(Gender.FEMALE))
                females.add(person);
        }
        females.forEach(System.out::println);//It prints all values


        //Declarative approach

        //1.Filter
        List<Person> females2=people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

        //2.Sort
        List<Person> sort= people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        sort.forEach(System.out::println);

        //3.All match
        boolean allMatch=people.stream()
                .allMatch(person -> person.getAge()>10);//The all list age is bigger than 10

        //4.None Match
        boolean anyMatch=people.stream()
                .anyMatch(person ->person.getName().equals("Mahmut") );
        System.out.println(anyMatch);

        //5.Max
        people.stream().max(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);

        //6.Min
        people.stream().min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //7.Group
        Map <Gender,List<Person>> groupByGender=people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        //8.Finds the oldest female in the List
        Optional<String> oldFemale=  people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldFemale.ifPresent(System.out::println);

        //Integer Stream

        //9.It prints values btw 1-10. 10 is not included
        IntStream
                .range(1,10)
                .forEach(System.out::println);
        System.out.println();

        //10.It prints values btw 1-20 but first 2 elements skipped.
        IntStream
                .range(1,20)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("---------------");

        //11.Summary
        System.out.println(
                IntStream
                        .range(1,6)//Remember 6 is not included
                        .sum()
        );
        //Output:15
        System.out.println();

        //12.Sorted and findFirst
        Stream.of("Adam","Ava","Aneri","Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
        //Output: Adam

        //13. Stream from Array, sort, filter and print
        int a[]={2,4,6,8,10};
        String [] names={"Al","Ankit","Kushal","Brent","Sarika","Amanda","Hans","Shivika","Sarah"};
        stream(names)    //Same as Stream.of(names)
                .filter(x -> x.startsWith("S"))     //Filter items only start with "S"
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        //14.Average of squares of an int array
        Arrays.stream(a)
                .map(x -> x*x)      //Takes square of every elements
                .average()          //Average of array
                .ifPresent(System.out::println);
        System.out.println();
        //Output:44.0

        //15.Stream from List, filter and print
        List<String> humansName=Arrays.asList("Al","Ankit","Kushal","Brent","Sarika","Amanda","Hans","Shivika","Sarah");
        humansName
                .stream()
                .map(String::toLowerCase)       //Convert all string to lowercase
                .filter( x-> x.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();
        //Output:al, ankit, amanda

        //16.Find the smallest 3 numbers of array
        int arrayInt[]={4,1,13,90,16,2,0};
        Arrays.stream(arrayInt)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
        System.out.println();



    }
    private static List<Person> getPeople(){
        return List.of(
                new Person("John",21,Gender.MALE),
                new Person("Scarlett",20,Gender.FEMALE),
                new Person("Travis",22,Gender.MALE),
                new Person("Melissa",22,Gender.FEMALE),
                new Person("Nicki",9,Gender.FEMALE),
                new Person("James",21,Gender.MALE)
        );
    }
}
