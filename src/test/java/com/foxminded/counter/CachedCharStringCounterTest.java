package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharStringCounterTest {
    private static final String TEST_STRING = "111";
    private CachedCharStringCounter cachedCharCounter;

    @Mock
    private StringCounter<Character> mockCharStringCounter;

    @BeforeEach
    void setUp() {
        Map<Character, Long> map = new LinkedHashMap<>();
        map.put('1', 3L);
        Storage<Character, String> storage = new CharStorage(TEST_STRING, map);
        when(mockCharStringCounter.count(Mockito.any())).thenReturn(new CharStorage("147", new HashMap<>()));
        when(mockCharStringCounter.count(Mockito.eq(TEST_STRING))).thenReturn(storage);
    }

    @Test
    void count_shouldReturnCachedResult_whenCalledStringFromCache() {
        cachedCharCounter = new CachedCharStringCounter(mockCharStringCounter);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count(TEST_STRING);

        verify(mockCharStringCounter, times(1)).count(TEST_STRING);
    }

    @Test
    void count_shouldNotAffectTheResult() {
        cachedCharCounter = new CachedCharStringCounter(mockCharStringCounter);
        assertSame(mockCharStringCounter.count(TEST_STRING), cachedCharCounter.count(TEST_STRING));
    }

    @Test
    void count_shouldRemoveEldestEntry_whenAddMoreMaxEntries() {
        cachedCharCounter = new CachedCharStringCounter(mockCharStringCounter, 2);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count("TEST_STRING");
        cachedCharCounter.count("TEST");
        cachedCharCounter.count(TEST_STRING);

        verify(mockCharStringCounter, times(2)).count(TEST_STRING);
    }
}
