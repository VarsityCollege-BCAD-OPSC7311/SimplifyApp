package com.cpillay.simplifyapp;

import android.widget.Spinner;

public class information {
    String gender;
    String age;
    String height;
    String weight;
    Spinner system;

    public information(String enteredAge, String enteredWeight, String enteredHeight, String enteredGender, String selectedSystem) {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Spinner getSystem() {
        return system;
    }

    public void setSystem(Spinner system) {
        this.system = system;
    }

    public information(String gender, String age, String height, String weight, Spinner system) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.system = system;
    }
}
