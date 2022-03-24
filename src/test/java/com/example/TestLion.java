package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestLion {
    @Test
    public void testLionMale() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самец");
        assertEquals(true,lion.hasMane);
    }

    @Test
    public void testLionFemale() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самка");
        assertEquals(false,lion.hasMane);
    }

    @Test
    public void testLionOtherSex() throws Exception {
        Feline feline = new Feline();

        int exceptionWasThrown = 0;
        try {
            new Lion(feline,"Сам");
        } catch (Exception exception) {
            exceptionWasThrown = 1;
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
        assertEquals("Exception must throw", 1, exceptionWasThrown);
    }

    @Test
    public void testGetKittensFemale() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самка");
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void testGetKittensMale() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самец");
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected,lion.getFood());
    }
}
