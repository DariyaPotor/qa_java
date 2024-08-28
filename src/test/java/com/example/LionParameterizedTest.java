package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedManePresence;

    @Mock
    private Feline felineMock = Mockito.mock(Feline.class);

    public LionParameterizedTest(String sex, boolean expectedManePresence) {
        this.sex = sex;
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
    public void testManePresenceBasedOnSex() throws Exception {
        // Подготовка
        Lion lion = new Lion(sex, felineMock);

        // Выполнение
        boolean actualManePresence = lion.doesHaveMane();

        // Проверка
        Assert.assertEquals(expectedManePresence, actualManePresence);
    }
}