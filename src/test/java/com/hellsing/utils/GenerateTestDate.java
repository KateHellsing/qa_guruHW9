package com.hellsing.utils;

public class GenerateTestDate {

    RandomDate randomDate = new RandomDate();
    public String
            userName = randomDate.getRandomFullName(),
            userEmail = randomDate.getRandomEmail(),
            userCurrentAddress = randomDate.getRandomAddress(),
            userPermanentAddress = randomDate.getRandomAddress();
}

