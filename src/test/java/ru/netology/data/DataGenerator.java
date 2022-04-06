package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public DataGenerator() {
    }

    public static UserInfo generateUserInfo() {
        String login = "netology";
        String password = "awdr";
        return new UserInfo("netology", "awdr");
    }

    public static UserInfo getInvalidPasswordInfo() {
        Faker faker = new Faker(new Locale("en"));
        String login = "netology";
        String password = faker.internet().password();
        return new UserInfo(login, password);
    }
}
