package com.bilal.teacherdiary;

public class Student {
    private String name;
    private String rollNo;
    private String Class;

    public Student(String name, String rollNo, String Class) {
        this.name = name;
        this.rollNo = rollNo;
        this.Class = Class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getclass() {
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", Class=" + Class + "]";
    }

}
