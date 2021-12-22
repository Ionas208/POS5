package at.kaindorf.bank.pojos;

import lombok.Data;

/*
    Created by: Jonas Seidl
    Date: 22.12.2021
    Time: 14:47
*/
public enum Gender {
    M("m"),
    W("W");

    private final String value;

    private Gender(String value){
        this.value = value;
    }
}
