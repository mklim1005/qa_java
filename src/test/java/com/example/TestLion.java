package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    @Mock
    Feline feline;

    @Test
    public void testLionMale() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самец");
        assertTrue(lion.hasMane);
    }

    @Test
    public void testLionFemale() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самка");
        assertFalse(lion.hasMane);
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
        Mockito.when(this.feline.getKittens()).thenReturn(77);
        Lion lion = new Lion(this.feline,"Самка");
        assertEquals(77,lion.getKittens());
    }

    @Test
    public void testGetKittensMale() throws Exception {
        Mockito.when(this.feline.getKittens()).thenReturn(3);
        Lion lion = new Lion(this.feline,"Самец");
        assertEquals(3,lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,"Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected,lion.getFood());
    }
}
