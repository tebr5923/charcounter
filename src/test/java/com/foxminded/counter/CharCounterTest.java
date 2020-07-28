package com.foxminded.counter;

import com.foxminded.util.HashMapBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharCounterTest {

    @Test
    void count_shouldThrowIllegalArgumentException_whenStringIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                count(null)
        );
    }

    @Test
    void count_shouldReturnResult_whenTextIsRandom() {
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

        Map<Character, Integer> actual = count("Hello World!!!");
        assertEquals(expected, actual);
    }

    private Map<Character, Integer> count(String string) {
        return new CharCounter().count(string);
    }
}
