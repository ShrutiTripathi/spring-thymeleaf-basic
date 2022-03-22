package com.example.basic.thymleaf.controller;

import com.example.basic.thymleaf.model.UserCreationParameters;
import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class CreateUserFormData {
    @NotNull
    @Size(min = 1, max = 400)
    private String givenName;

    @NotNull
    @Size(min = 1, max = 400)
    private String familyName;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public UserCreationParameters toParameters() {
        return new UserCreationParameters(givenName, familyName);
    }
}