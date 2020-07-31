package com.foxminded.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter implements Counter<Character> {
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
        Map<Character, Long> map = new LinkedHashMap<>();
        for (char ch : string.toCharArray()) {
            long count = map.getOrDefault(ch, 0L);
            map.put(ch, count + 1);
        }
        return map;
    }
}
