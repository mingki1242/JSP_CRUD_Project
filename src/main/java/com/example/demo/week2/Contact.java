package com.example.demo.week2;

public class Contact {
    String name;
    String Phone_Num;
    String Email_Address;
    String Gender;

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone_Num() {
        return Phone_Num;
    }

    public void setPhone_Num(String phone_Num) {
        Phone_Num = phone_Num;
    }

    public void setName(String name) {
        this.name = name;
    }
}
