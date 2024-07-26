package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FelineTest {

    @Test
    public void testEatMeatProvidesCorrectDiet() throws Exception {
        // Подготовка
        Feline feline = new Feline();
        List<String> expectedDiet = Arrays.asList("Животные", "Птицы", "Рыба");

        // Выполнение
        List<String> actualDiet = feline.eatMeat();

        // Проверка
        Assert.assertEquals(expectedDiet, actualDiet);
    }

    @Test
    public void testGetFamilyReturnsExpectedValue() {
        // Подготовка
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        // Выполнение
        String actualFamily = feline.getFamily();

        // Проверка
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensReturnsSingleKittenByDefault() {
        // Подготовка
        Feline feline = new Feline();
        int expectedKittens = 1;

        // Выполнение
        int actualKittens = feline.getKittens();

        // Проверка
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensReturnsSpecifiedNumber() {
        // Подготовка
        Feline feline = new Feline();
        int numberOfKittens = 2;

        // Выполнение
        int actualKittens = feline.getKittens(numberOfKittens);

        // Проверка
        Assert.assertEquals(numberOfKittens, actualKittens);
    }
}