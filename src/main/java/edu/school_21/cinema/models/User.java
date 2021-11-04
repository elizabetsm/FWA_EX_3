package edu.school_21.cinema.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String pass;
    private List<SignModel> signModels = new ArrayList<>();
    private List<File> listOfFiles = new ArrayList<>();



    public User(){}

    public User(String firstName, String lastName, String phoneNumber, String pass, List<SignModel> signModels) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        this.signModels = signModels;
    }

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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<SignModel> getSignModels() {
        return signModels;
    }

    public void setSignModels(List<SignModel> signModels) {
        this.signModels = signModels;
    }

    public List<File> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(List<File> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }
}
