package com.revhalisi.appchurch.api.models;

public class otpModel {
    public String getOtp() {
        return otp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String otp,phoneNumber;

    public otpModel(String otp, String phoneNumber) {
        this.otp= otp;
        this.phoneNumber= phoneNumber;
    }
}
