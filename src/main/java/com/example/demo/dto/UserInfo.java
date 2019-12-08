package com.example.demo.dto;

public class UserInfo {
    private String sub;
    private String iss;
    private String aud;
    private String nhs_number;
    private String birthdate;
    private String family_name;
    private String im1_token;

    public void setIss(String iss) {
        this.iss = iss;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public void setNhs_number(String nhs_number) {
        this.nhs_number = nhs_number;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public void setIm1_token(String im1_token) {
        this.im1_token = im1_token;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSub() {
        return sub;
    }

    public String getIss() {
        return iss;
    }

    public String getAud() {
        return aud;
    }

    public String getNhs_number() {
        return nhs_number;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getFamily_name() {
        return family_name;
    }

    public String getIm1_token() {
        return im1_token;
    }
}
