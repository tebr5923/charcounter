package com.foxminded.counter;

import com.foxminded.util.HashMapBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharCounterTest {
    private final CharCounter charCounter = new CharCounter();

    @Test
    void count_shouldThrowIllegalArgumentException_whenStringIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                charCounter.count(null)
        );
    }

    @Test
    void count_shouldThrowIllegalArgumentException_whenStringIsEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                charCounter.count("")
        );
    }

    @Test
    void count_shouldReturnResult_whenStringIsRandom() {
        Map<Character, Integer> expected = new HashMapBuilder<Character>()
                .add('H', 1)
                .add('H', 1)
                .add('e', 1)
                .add('l', 3)
                .add('o', 2)
                .add(' ', 1)
                .add('W', 1)
                .add('r', 1)
                .add('d', 1)
                .add('!', 3)
                .build();

        Map<Character, Integer> actual = charCounter.count("Hello World!!!");
        assertEquals(expected, actual);
    }

    @Test
    void count_shouldReturnResult_whenOneCharsString() {
        Map<Character, Integer> expected = new HashMapBuilder<Character>()
                .add('1', 9)
                .build();

        Map<Character, Integer> actual = charCounter.count("111111111");
        assertEquals(expected, actual);
    }

    @Test
    void count_shouldReturnResult_whenOnlySpacesString() {
        Map<Character, Integer> expected = new HashMapBuilder<Character>()
                .add(' ', 5)
                .build();

        Map<Character, Integer> actual = charCounter.count("     ");
        assertEquals(expected, actual);
    }
}
