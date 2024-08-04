package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String gender;
    private final boolean expectedManePresence;

    public LionParameterizedTest(String gender, boolean expectedManePresence) {
        this.gender = gender;
        this.expectedManePresence = expectedManePresence;
    }

    @Parameterized.Parameters
    public static Object[] parameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testManePresenceBasedOnGender() throws Exception {
        // Подготовка
        Lion lion = new Lion(gender);

        // Выполнение
        boolean actualManePresence = lion.doesHaveMane();

        // Проверка
        Assert.assertEquals(expectedManePresence, actualManePresence);
    }
}