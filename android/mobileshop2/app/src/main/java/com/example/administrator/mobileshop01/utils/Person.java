package com.example.administrator.mobileshop01.utils;

public class Person {
    private int id;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getAge() {
        return id;
    }

    public void setAge(int age) {
        this.id = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
