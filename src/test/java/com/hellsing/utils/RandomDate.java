package com.hellsing.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomDate {
    Faker fakerEn = new Faker(new Locale("en"));

    public String getRandomFullName() {

        return fakerEn.name().fullName();
    }

    public String getRandomEmail() {

        return fakerEn.internet().emailAddress();
    }

    public String getRandomAddress() {

        return fakerEn.address().fullAddress();
    }
}
