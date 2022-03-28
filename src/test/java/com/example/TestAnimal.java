package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAnimal {
    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        assertEquals(List.of("Трава", "Различные растения"),animal.getFood("Травоядное"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"),animal.getFood("Хищник"));
    }

    @Test
    public void testGetFoodException() {
        Animal animal = new Animal();
        int exceptionWasThrough = 0;
        try {
            animal.getFood("Винни");
        } catch(Exception exception) {
            exceptionWasThrough = 1;
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",exception.getMessage());
        }
        assertEquals(1, exceptionWasThrough);
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
