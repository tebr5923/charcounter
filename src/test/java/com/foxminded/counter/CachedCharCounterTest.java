package com.foxminded.counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {
    private static final String TEST_STRING = "111";
    private final Map<Character, Integer> map = new HashMap<>();
    private CachedCharCounter cachedCharCounter;

    @Mock
    private Counter<Character> mockCharCounter;

    @BeforeEach
    void setUp() {
        map.put('1', 3);
        when(mockCharCounter.count(Mockito.eq(TEST_STRING))).thenReturn(map);

        cachedCharCounter = new CachedCharCounter(mockCharCounter);
    }

    @Test
    void count_shouldReturnCachedResult_whenCalledStringFromCache() {
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count(TEST_STRING);
        cachedCharCounter.count(TEST_STRING);

        verify(mockCharCounter).count(TEST_STRING);
    }

    @Test
    void count_shouldNotAffectTheResult() {
        assertSame(mockCharCounter.count(TEST_STRING), cachedCharCounter.count(TEST_STRING));
    }
}
