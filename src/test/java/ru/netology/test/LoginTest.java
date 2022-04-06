package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLUtils;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataGenerator.*;

public class LoginTest {
    
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @AfterAll
    static void cleanUp() {
        SQLUtils.clearTables();
    }

    @Test
    void shouldLogin() {
        val validUser = generateUserInfo();
        val loginPage = new LoginPage();
        val verificationPage = loginPage.validLogin(validUser);
        verificationPage.validVerify(SQLUtils.getVerificationCode());
    }

    @Test
    void shouldBlock() {
        val invalidPassword = getInvalidPasswordInfo();
        val loginPage = new LoginPage();
        loginPage.login(invalidPassword);
        loginPage.cleanFields();
        loginPage.login(invalidPassword);
        loginPage.cleanFields();
        loginPage.login(invalidPassword);
        loginPage.blockNotification();
    }

}


