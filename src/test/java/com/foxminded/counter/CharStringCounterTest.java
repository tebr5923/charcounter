package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;
import com.foxminded.util.HashMapBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharStringCounterTest {
    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new CharStringCounter()),
                Arguments.of(new StreamCharStringCounter()));
    }

    @ParameterizedTest
    @MethodSource("generator")
    void count_shouldThrowIllegalArgumentException_whenStringIsNull(StringCounter<Character> charStringCounter) {
        assertThrows(IllegalArgumentException.class, () ->
                charStringCounter.count(null)
        );
    }

    @ParameterizedTest
    @MethodSource("generator")
    void count_shouldThrowIllegalArgumentException_whenStringIsEmpty(StringCounter<Character> charStringCounter) {
        assertThrows(IllegalArgumentException.class, () ->
                charStringCounter.count("")
        );
    }

    @ParameterizedTest
    @MethodSource("generator")
    void count_shouldReturnResult_whenStringIsRandom(StringCounter<Character> charStringCounter) {
        Map<Character, Long> map = new HashMapBuilder<Character>()
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
        String inputString = "Hello World!!!";
        Storage<Character, String> expected = new CharStorage(inputString, map);

        Storage<Character, String> actual = charStringCounter.count(inputString);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void count_shouldReturnResult_whenOneCharsString(StringCounter<Character> charStringCounter) {
        Map<Character, Long> map = new HashMapBuilder<Character>()
                .add('1', 9)
                .build();
        String inputString = "111111111";
        Storage<Character, String> expected = new CharStorage(inputString, map);

        Storage<Character, String> actual = charStringCounter.count(inputString);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void count_shouldReturnResult_whenOnlySpacesString(StringCounter<Character> charStringCounter) {
        Map<Character, Long> map = new HashMapBuilder<Character>()
                .add(' ', 5)
                .build();
        String inputString = "     ";
        Storage<Character, String> expected = new CharStorage(inputString, map);

        Storage<Character, String> actual = charStringCounter.count(inputString);
        assertEquals(expected, actual);
    }
}
