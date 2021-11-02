package edu.school_21.cinema.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SignModel {
    private String ip;
    private Date date = new Date();

    public SignModel(String ip, Date date) {
        this.ip = ip;
        this.date = date;
    }

    public SignModel(String ip) {
        this.ip = ip;
    }
}
