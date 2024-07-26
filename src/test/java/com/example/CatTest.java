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
        // Arrange
        Cat cat = new Cat(new Feline());
        String expectedSound = "Мяу";

        // Act
        String actualSound = cat.getSound();

        // Assert
        Assert.assertEquals("Expected cat to say 'Мяу'", expectedSound, actualSound);
    }

    @Test
    public void shouldReturnCorrectFood() throws Exception {
        // Arrange
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(mockFeline);

        // Act
        List<String> actualFood = cat.getFood();

        // Assert
        Assert.assertEquals("Expected food list to match", expectedFood, actualFood);
    }
}