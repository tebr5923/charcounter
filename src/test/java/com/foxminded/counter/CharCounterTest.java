package com.foxminded.counter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void count_shouldReturnResult_whenTextIsRandom() {
        Map<Character, Integer> expected = new HashMap<>();

        Counter<Character> counter = new CharCounter();
        Map<Character, Integer> actual = counter.count("Hello World!!!");

        assertEquals(expected, actual);
    }
}
