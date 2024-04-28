package com.project.project2;

/**
 * ClassName:
 * Description: 客戶類
 *
 * @Author Rin
 * @Create 2024/3/12 下午 10:39
 * @Version 1.0
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phoneNumber;
    private String email;

    public Customer() {
    }

    public Customer(String name, char gender, int age, String phoneNumber, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
