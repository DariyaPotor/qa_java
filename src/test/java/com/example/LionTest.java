package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class LionTest extends BaseTest {

    @Mock
    Feline felineMock;

    @Test
    public void testGetKittensReturnsExpectedValue() throws Exception {
        // Настройка
        Lion lion = new Lion("Самец");
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int expectedKittenCount = 1;

        // Выполнение
        int actualKittenCount = lion.getKittens();

        // Проверка
        Assert.assertEquals(expectedKittenCount, actualKittenCount);
    }

    @Test
    public void testGetFoodReturnsExpectedList() throws Exception {
        // Настройка
        Lion lion = new Lion("Самка");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = Arrays.asList("Животные", "Птицы", "Рыба");

        // Выполнение
        List<String> actualFoodList = lion.getFood();

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