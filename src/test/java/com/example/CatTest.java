package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class CatTest extends BaseTest {

    @Mock
    private Feline mockFeline;

    @Test
    public void shouldReturnCorrectSound() {
        // Подготовка - создание объекта Cat
        Cat cat = new Cat(new Feline());
        String expectedSound = "Мяу";

        // Получение звука кота
        String actualSound = cat.getSound();

        // Проверка
        Assert.assertEquals("Кот должен издавать звук 'Мяу'", expectedSound, actualSound);
    }

    @Test
    public void shouldReturnCorrectFood() throws Exception {
        // Подготовка
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(mockFeline);

        // Выполнение
        List<String> actualFood = cat.getFood();

        // Проверка
        Assert.assertEquals("Кот должен есть рыбу", expectedFood, actualFood);
    }
}