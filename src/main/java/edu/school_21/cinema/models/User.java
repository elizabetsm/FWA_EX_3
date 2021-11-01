package edu.school_21.cinema.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String pass;
    private List<File> listOfImages = new ArrayList<>();

    {
        listOfImages.add(new File("/Users/lizka/Desktop/FWA_EX_3/261046917.jpg" ));
    }

    public User(){}

    public User(String firstName, String lastName, String phoneNumber, String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<File> getListOfImages(){
        return listOfImages;
    }
}
