package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestAlex {
    @Test
    public void testGetKittens() throws Exception {
        Alex alex = new Alex(new Feline());
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testGetFriends() throws Exception {
        Alex alex = new Alex(new Feline());
        List<String> expected = List.of("Марти", "Глории", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(new Feline());
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
}
