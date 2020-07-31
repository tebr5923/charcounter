package com.foxminded.counter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCharCounter implements Counter<Character> {
    @Override
    public Map<Character, Long> count(String inputString) {
        checkInputString(inputString);
        return countChars(inputString);
    }

    private void checkInputString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null can't be counted");
        }
        if (string.equals("")) {
            throw new IllegalArgumentException("String is empty, can't be counted");
        }
    }

    private Map<Character, Long> countChars(String string) {
        Stream<Character> stream = toStream(string);
        Map<Character, Long> map;
        map = stream.collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        return map;
    }

    private Stream<Character> toStream(String string) {
        Character[] characters = new Character[string.length()];
        //boxed
        int i = 0;
        for (char ch : string.toCharArray()) {
            characters[i] = ch;
            i++;
        }
        return Arrays.stream(characters);
    }
}
