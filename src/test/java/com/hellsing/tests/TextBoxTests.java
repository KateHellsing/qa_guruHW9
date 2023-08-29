package com.hellsing.tests;

import com.hellsing.pages.TextBoxPage;
import com.hellsing.utils.GenerateTestDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    static GenerateTestDate utils = new GenerateTestDate();

    @CsvSource(value = {
            "Morticia Addams, morticia_addams@gmail.com, Scary Castle New York City Central Park, Scary Castle",
            "Homes Addams, homes_addams@gmail.com, Scary Castle New York City Central Park, Scary Castle",
            "Wednesday Addams, wednesday_addams@gmail.com, Scary Castle New York City Central Park, Scary Castle",
            "Pugsley Addams, pugsley_addams@gmail.com, Scary Castle New York City Central Park,  Scary Castle"
    })

    @DisplayName("CsvSourceTest")
    @ParameterizedTest()
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName(utils.userName)
                .setUserEmail(utils.userEmail)
                .setCurrentAddress(utils.userCurrentAddress)
                .setPermanentAddress(utils.userPermanentAddress)
                .submit()
                .checkResult(
                        utils.userName,
                        utils.userEmail,
                        utils.userCurrentAddress,
                        utils.userPermanentAddress);
    }

    @CsvFileSource(resources = "/textBoxTestData.csv")
    @DisplayName("CsvFileSourceTest")
    @ParameterizedTest()
    void textBoxFromCsvFileTest(String userName, String userEmail, String userCurrentAddress, String userPermanentAddress) {
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(userCurrentAddress)
                .setPermanentAddress(userPermanentAddress)
                .submit()
                .checkResult(
                        userName,
                        userEmail,
                        userCurrentAddress,
                        userPermanentAddress);
    }
    static Stream<Arguments> textBoxFromMethodSource() {
        return Stream.of(
                Arguments.of(utils.userName, utils.userEmail, utils.userCurrentAddress, utils.userPermanentAddress)
        );
    }

    @MethodSource
    @DisplayName("MethodSourceTest")
    @ParameterizedTest
    void textBoxFromMethodSource
            (String randomUserName, String randomUserEmail, String randomUserCurrentAddress, String randomUserPermanentAddress) {
        textBoxPage.openPage()
                .setUserName(randomUserName)
                .setUserEmail(randomUserEmail)
                .setCurrentAddress(randomUserCurrentAddress)
                .setPermanentAddress(randomUserPermanentAddress)
                .submit()
                .checkResult(
                        randomUserName,
                        randomUserEmail,
                        randomUserCurrentAddress,
                        randomUserPermanentAddress);
    }
}