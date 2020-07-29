package com.foxminded.counter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CachedCharCounterTest {
    private CachedCharCounter cachedCharCounter;

    @BeforeEach
    void setUp() {
        cachedCharCounter = new CachedCharCounter(new CharCounter());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void count_shouldReturnTrueSize_whenCalledFiveTimes() {
        int excepted = 5;

        cachedCharCounter.count("111");
        cachedCharCounter.count("222");
        cachedCharCounter.count("333");
        cachedCharCounter.count("444");
        cachedCharCounter.count("555");
        int actual = cachedCharCounter.size();

        assertEquals(excepted, actual);
    }

    @Test
    void count_shouldReturnMaxSize_whenCalledMoreMaxTimes() {
        int excepted = 10;

        cachedCharCounter.count("111");
        cachedCharCounter.count("222");
        cachedCharCounter.count("333");
        cachedCharCounter.count("444");
        cachedCharCounter.count("555");
        cachedCharCounter.count("666");
        cachedCharCounter.count("777");
        cachedCharCounter.count("888");
        cachedCharCounter.count("999");
        cachedCharCounter.count("101010");
        cachedCharCounter.count("111111");
        cachedCharCounter.count("121212");
        int actual = cachedCharCounter.size();

        assertEquals(excepted, actual);
    }

    @Test
    void count_shouldRemoveEldestEntry_whenCalledMoreMaxTimes() {
        cachedCharCounter.count("111");
        cachedCharCounter.count("222");
        cachedCharCounter.count("333");
        cachedCharCounter.count("444");
        cachedCharCounter.count("555");
        cachedCharCounter.count("666");
        cachedCharCounter.count("777");
        cachedCharCounter.count("888");
        cachedCharCounter.count("999");
        cachedCharCounter.count("101010");
        cachedCharCounter.count("111111");
        cachedCharCounter.count("121212");
        Map<Character, Integer> actual = cachedCharCounter.getCachedCounter("111");
        assertNull(actual);

        actual = cachedCharCounter.getCachedCounter("222");
        assertNull(actual);
    }
}
