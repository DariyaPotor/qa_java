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

    @Test(expected = Exception.class)
    public void testInvalidGenderThrowsException() throws Exception {
        new Lion("ошибка");
    }

    @Test
    public void testInvalidGenderExceptionMessage() {
        String expectedErrorMessage = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = null;
        try {
            new Lion("ошибка");
        } catch (Exception ex) {
            exception = ex;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(expectedErrorMessage, exception.getMessage());
    }
}