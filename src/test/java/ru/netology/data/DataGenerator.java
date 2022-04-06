package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public DataGenerator() {
    }

    public static UserInfo generateUserInfo() {
        String login = "vasya";
        String password = "qwerty123";
        return new UserInfo("vasya", "qwerty123");
    }

    public static UserInfo getInvalidPasswordInfo() {
        Faker faker = new Faker(new Locale("en"));
        String login = "vasya";
        String password = faker.internet().password();
        return new UserInfo(login, password);
    }
}
