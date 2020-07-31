package com.foxminded.counter;

import java.util.Map;
import java.util.function.Function;
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
        Stream<Character> stream = string.chars().mapToObj(ch -> (char) ch);
        Map<Character, Long> map;
        map = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map;
    }
}
