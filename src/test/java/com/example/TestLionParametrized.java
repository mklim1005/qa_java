package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLionParametrized {
    private final String sex;
    private final boolean expected;

    public TestLionParametrized(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][] {
                { "Самка", false},
                { "Самец", true},
        };
    }

    @Test
    public void testDoesHasMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,sex);
        assertEquals(expected,lion.doesHaveMane());
    }
}
