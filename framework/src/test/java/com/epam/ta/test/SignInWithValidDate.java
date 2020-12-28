package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.LoginPage;
import com.epam.ta.page.MainPage;
import com.epam.ta.page.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInWithValidDate extends CommonConditions{
    @Test
    public void signInWithDate(){
        MainPage mainPage = new MainPage(driver)
                .openPage()
                .signIn();
        LoginPage loginPage = new LoginPage(driver)
                .enterEmail()
                .enterPassword()
                .signIn();

        String nameUserFromMainPage = new MainPage(driver)
                .loginLabel();
        String nameUserFromProfile = new Profile(driver)
                .openPage()
                .name();
        Assert.assertEquals(nameUserFromMainPage, nameUserFromProfile);

    }
}
