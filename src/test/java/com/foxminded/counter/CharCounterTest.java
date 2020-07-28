package com.foxminded.counter;

import com.foxminded.util.HashMapBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharCounterTest {

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

        Counter<Character> counter = new CharCounter();
        Map<Character, Integer> actual = counter.count("Hello World!!!");

        assertEquals(expected, actual);
    }
}
