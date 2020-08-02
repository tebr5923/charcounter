package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {
    private static final String TEST_STRING = "111";
    private CachedCharCounter cachedCharCounter;

    @Mock
    private Counter<Character> mockCharCounter;

    @BeforeEach
    void setUp() {
        Map<Character, Long> map = new LinkedHashMap<>();
        map.put('1', 3L);
        Storage<Character> storage = new CharStorage(TEST_STRING, map);
        when(mockCharCounter.count(Mockito.eq(TEST_STRING))).thenReturn(storage);
    }

    @Test
    void count_shouldReturnCachedResult_whenCalledStringFromCache() {
        cachedCharCounter = new CachedCharCounter(mockCharCounter);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count(TEST_STRING);

        verify(mockCharCounter, times(1)).count(TEST_STRING);
    }

    @Test
    void count_shouldNotAffectTheResult() {
        cachedCharCounter = new CachedCharCounter(mockCharCounter);
        assertEquals(mockCharCounter.count(TEST_STRING), cachedCharCounter.count(TEST_STRING));
    }

    @Test
    void count_shouldRemoveEldestEntry_whenAddMoreMaxEntries() {
        cachedCharCounter = new CachedCharCounter(mockCharCounter, 2);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count("TEST_STRING");
        cachedCharCounter.count("TEST");
        cachedCharCounter.count(TEST_STRING);

        verify(mockCharCounter, times(2)).count(TEST_STRING);
    }
}
