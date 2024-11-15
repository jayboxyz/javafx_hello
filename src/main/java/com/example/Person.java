//package com.example;
//
//import javafx.beans.property.SimpleStringProperty;
//
///**
// * @author huzhibo
// * @Date 2024-10-10 19:32
// * @desc
// */
//// 数据模型类
//public class Person {
//    private final SimpleStringProperty firstName;
//    private final SimpleStringProperty lastName;
//    private final SimpleStringProperty email;
//
//    Person(String firstName, String lastName, String email) {
//        this.firstName = new SimpleStringProperty(firstName);
//        this.lastName = new SimpleStringProperty(lastName);
//        this.email = new SimpleStringProperty(email);
//    }
//
//    public String getFirstName() {
//        return firstName.get();
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName.set(firstName);
//    }
//
//    public SimpleStringProperty firstNameProperty() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName.get();
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName.set(lastName);
//    }
//
//    public SimpleStringProperty lastNameProperty() {
//        return lastName;
//    }
//
//    public String getEmail() {
//        return email.get();
//    }
//
//    public void setEmail(String email) {
//        this.email.set(email);
//    }
//
//    public SimpleStringProperty emailProperty() {
//        return email;
//    }
//}