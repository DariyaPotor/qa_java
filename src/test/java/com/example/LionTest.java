package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class LionTest {

    Feline felineMock;
    Lion lionMale;
    Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
        lionMale = new Lion("Самец");
        lionFemale = new Lion("Самка");

        setFelineMock(lionMale, felineMock);
        setFelineMock(lionFemale, felineMock);
    }

    private void setFelineMock(Lion lion, Feline felineMock) throws Exception {
        Field felineField = Lion.class.getDeclaredField("feline");
        felineField.setAccessible(true);
        felineField.set(lion, felineMock);
    }

    @Test
    public void testGetKittensReturnsExpectedValue() {
        // Настройка
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int expectedKittenCount = 1;

        // Выполнение
        int actualKittenCount = lionMale.getKittens();

        // Проверка
        Assert.assertEquals(expectedKittenCount, actualKittenCount);
    }

    @Test
    public void testGetFoodReturnsExpectedList() throws Exception {
        // Настройка
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = Arrays.asList("Животные", "Птицы", "Рыба");

        // Выполнение
        List<String> actualFoodList = lionFemale.getFood();

        // Проверка
        Assert.assertEquals(expectedFoodList, actualFoodList);
    }

    @Test
    public void testInvalidGenderThrowsException() {
        String expectedErrorMessage = "Используйте допустимые значения пола животного - самей или самка";

        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("ошибка");
        });

        Assert.assertEquals(expectedErrorMessage, exception.getMessage());
    }
}