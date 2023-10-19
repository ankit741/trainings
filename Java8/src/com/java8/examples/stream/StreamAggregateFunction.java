package com.java8.examples.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAggregateFunction {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "ankit", "ankit@gmail.com", "9599046122", 300));
        studentList.add(new Student(3, "abhinav", "abhinav@gmail.com", "9599046023", 280));
        studentList.add(new Student(1, "rajesh", "rajesh@gmail.com", "9599046024", 302));
        studentList.add(new Student(2, "ajay", "ajay@gmail.com", "9599046022", 250));

        // group by student id.
        Map<Integer, List<Student>> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getId));

        //average marks
        double average = studentList.stream().mapToInt(e -> e.getTotalMarks()).average().getAsDouble();

        //get min marks
        Optional<Student> min = studentList.stream().min(Comparator.comparing(Student::getTotalMarks));

        //get max marks
        Optional<Student> max = studentList.stream().max(Comparator.comparing(Student::getTotalMarks));
    }
}

class Student {

    private int id;
    private String name;
    private String email;
    private String mobile;
    private int totalMarks;

    public Student(int id, String name, String email, String mobile, int totalMarks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.totalMarks = totalMarks;
    }
    public int getTotalMarks() {
        return totalMarks;
    }
    public Student(int id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getMobile() {
        return mobile;
    }
}


